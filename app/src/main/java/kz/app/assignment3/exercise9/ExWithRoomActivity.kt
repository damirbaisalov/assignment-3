package kz.app.assignment3.exercise9

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.app.assignment3.R
import kz.app.assignment3.models.UserRoom

class ExWithRoomActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserDatabaseViewModel
    private lateinit var userAdapter: UserRoomAdapter
    private lateinit var editTextName: EditText
    private lateinit var editTextLogin: EditText
    private lateinit var buttonAddUser: Button
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex_with_room)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextName = findViewById(R.id.editTextNameRoom)
        editTextLogin = findViewById(R.id.editTextLoginRoom)
        buttonAddUser = findViewById(R.id.buttonAddUserRoom)
        recyclerView = findViewById(R.id.recyclerViewRoom)

        val userDao = AppDatabase.getDatabase(application).userDao()
        userViewModel = UserViewModelFactory(userDao).create(UserDatabaseViewModel::class.java)

        userAdapter = UserRoomAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        userViewModel.users.observe(this) { users ->
            userAdapter.updateUsers(users)
        }

        buttonAddUser.setOnClickListener {
            val name = editTextName.text.toString()
            val login = editTextLogin.text.toString()

            if (name.isNotEmpty() && login.isNotEmpty()) {
                userViewModel.insert(UserRoom(name = name, login = login))
                editTextName.text.clear()
                editTextLogin.text.clear()
            } else {
                Toast.makeText(this, "Please enter edit texts", Toast.LENGTH_SHORT).show()
            }
        }

        userViewModel.getAllUsers()
    }
}