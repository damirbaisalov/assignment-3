package kz.app.assignment3.exercise78

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.app.assignment3.R
import kz.app.assignment3.models.User

class ExWithLiveDataActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private lateinit var editTextName: EditText
    private lateinit var editTextLogin: EditText
    private lateinit var buttonAddUser: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex_with_live_data)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextName = findViewById(R.id.editTextName)
        editTextLogin = findViewById(R.id.editTextLogin)
        buttonAddUser = findViewById(R.id.buttonAddUser)
        recyclerView = findViewById(R.id.recyclerView)
        userAdapter = UserAdapter(emptyList())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        userViewModel.users.observe(this) { users ->
            userAdapter.updateUsers(users)
        }

        addAndUpdateUsers()

        buttonAddUser.setOnClickListener {
            val name = editTextName.text.toString()
            val login = editTextLogin.text.toString()

            if (name.isNotEmpty() && login.isNotEmpty()) {
                userViewModel.addUser(User(0, name, login))
                editTextName.text.clear()
                editTextLogin.text.clear()
            } else {
                Toast.makeText(this, "Please enter edit texts", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Part of ex 7
    private fun addAndUpdateUsers() {
        userViewModel.addUser(User(4, "User4", "User4Login"))
    }

}