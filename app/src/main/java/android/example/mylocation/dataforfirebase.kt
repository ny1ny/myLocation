package android.example.mylocation

class dataforfirebase {
    lateinit var name:String
    lateinit var username:String
    lateinit var email:String
   lateinit var number:String
    lateinit var password:String

    constructor(name: String, username: String, email: String, number: String, password: String) {
        this.name = name
        this.username = username
        this.email = email
        this.number = number
        this.password = password
    }

    constructor()



}