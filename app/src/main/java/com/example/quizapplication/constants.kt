package com.example.quizapplication

object constants {
 const val USER_NAME:String="user_name"
    const val Total_question:String="total _questions"
    const val Correct_answer:String ="correct answer"
    fun getquestions():ArrayList<question>{
        val questionlist=ArrayList<question>()

        val ques1=question(
            1,"which country this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India",
            "Australia",
            "Austria",
            "none of the above",
            1
        )
        questionlist.add(ques1)
        val ques2=question(
                2," Who painted the Mona Lisa?",
            R.drawable.monalica1,
            "Michelangelo",
        "Vincent van Gogh",
        "Pablo Picasso",
        "Leonardo da Vinci",
        4
        )
        questionlist.add(ques2)
        val ques3=question(
            3,"What is the largest ocean in the world?",
            R.drawable.ocean1,
            "Atlantic Ocean",
            "Indian Ocean",
            " Arctic Ocean",
            "Pacific Ocean",
            4
        )
        questionlist.add(ques3)
        val ques4=question(
            4," When did World War II end?",
            R.drawable.worldwar1,
            "1945",
            "1932",
            " 1942",
            "1950",
            1
        )
        questionlist.add(ques4)
        val ques5=question(
            5," What is the chemical symbol for gold?",
            R.drawable.gold1,
            "Ag",
            "Au",
            "Fe",
            "Cu",
            2
        )
        questionlist.add(ques5)
        val ques6=question(
            6," How many bones are in the human body?",
            R.drawable.bone1,
            "202",
            "300",
            "206",
            "200",
            3
        )
        questionlist.add(ques6)
        val ques7=question(
            7,"  Who wrote the Harry Potter series?",
            R.drawable.harry1,
            "C.S. Lewis",
            "J.K. Rowling",
            " Roald Dahl",
            " Stephen King",
            2
        )
        questionlist.add(ques7)

        val ques8=question(8,"  Who won the FIFA World Cup in 2022?",
            R.drawable.fifa1,
            "Germany",
            "Brazil",
            "France",
            "Argentina",
            4
        )
        questionlist.add(ques8)
        val ques9=question(
            9,"  Who won the T20 World Cup in 2024?",
            R.drawable.worlcup201,
            "India",
            "Pakistan",
            "Australia",
            "South Africa",
            1
        )
        questionlist.add(ques9)
        val ques10=question(
            10,"  Which cricketer is this?",
            R.drawable.virat1,
            "King kohli",
            "Sachin",
            "Rohit",
            "Gill",
            1
        )
        questionlist.add(ques10)


        return questionlist
    }
}