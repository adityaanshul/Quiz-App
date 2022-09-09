package com.adityapp.quizeriya

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "Total"
    const val CORRECT_ANSWERS : String = "Correct Answers Stored"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>() //in this ArrayList is storing objects of Dataclass Question

        val que1 = Question( //0 index
            1,
            "This is the flag of which Scandinavian country?",
            R.drawable.quiz_q1,
            "Sweden",
            "Norway",
            "Denmark",
            "Switzerland",
            3
        )
        questionList.add(que1)

        val que2 = Question(
            2,
            "What is the name of this traditional garment, which is the national dress of Japan?",
            R.drawable.quiz_q2,
            "Ao dai",
            "Hanbok",
            "Kimono",
            "Sumimasen",
            3
        )
        questionList.add(que2)

        val que3 = Question(
            3,
            "Which type of light bulbs are they?",
            R.drawable.quiz_q3,
            "Incandescent bulbs",
            "Halogen bulbs",
            "LED bulbs",
            "Fluorescent light bulbs",
            1
        )
        questionList.add(que3)

        val que4 = Question(
            4,
            "What is the name of this religion, which is mainly popular in Asian countries?",
            R.drawable.quiz_q4,
            "Sikh",
            "Hinduism",
            "Buddhism",
            "Jainism",
            3
        )
        questionList.add(que4)

        val que5 = Question(
            5,
            "What is the name of the first U.S. President on the right of this picture?",
            R.drawable.quiz_q5,
            " George Washington",
            "Abraham Lincoln",
            "Thomas Jefferson",
            "Theodore Roosevelt",
            2
        )
        questionList.add(que5)

        val que6 = Question(
            6,
            "What is the name of this sport?",
            R.drawable.quiz_q6,
            "Cricket",
            "Corkball",
            "Kickball",
            "Baseball",
            1
        )
        questionList.add(que6)

        val que7 = Question(
            7,
            "What is the name of this world-known tourist destination in Italy?",
            R.drawable.quiz_q7,
            "Ponte Vecchio",
            "Les Invalides",
            "South Africa",
            "Leaning Tower of Pisa",
            4
        )
        questionList.add(que7)

        val que8 = Question(
            8,
            "From which country did this musical instrument originally come from?",
            R.drawable.quiz_q8,
            "Spain",
            "Germany",
            "France",
            "India",
            1
        )
        questionList.add(que8)

        val que9 = Question(
            9,
            "What is the name of this Pokemon?",
            R.drawable.quiz_q9,
            "Raichu",
            "Pichu",
            "Moltres",
            "Pikachu",
            4
        )
        questionList.add(que9)

        val que10 = Question(
            10,
            "What is the name of this automotive brand?",
             R.drawable.quiz_q10,
            "BMW",
            "volkswagen",
            "Ford",
            "Citroen",
            1
        )


        questionList.add(que10)

        val que11 = Question(
            11,
            "Who is the author of the famous painting “Mona Lisa?",
            R.drawable.quiz_q11,
            "Rembrandt",
            "Michelangelo",
            "Leonardo Da Vinci",
            "leonardo Dicaprio",
            3
        )


        questionList.add(que11)

        val que12 = Question(
            12,
            "What is the name of this fictional cat with no mouth and a red bow?",
            R.drawable.quiz_q12,
            "Doremon",
            "Totoro",
            "Aanya",
            "Hello Kitty",
            4
        )


        questionList.add(que12)

        val que13 = Question(
            13,
            "This statue is the award for which prestigious and famous event?\n",
            R.drawable.quiz_q13,
            "The Grammy Award",
            "Oscars",
            "The Pulitzer Prize",
            "The Booker Prize",
            2
        )


        questionList.add(que13)

        val que14 = Question(
            14,
            "In which city is this distinctive and famous building located?",
            R.drawable.quiz_q14,
            "Sydney, Australia",
            "Auckland, New Zealand",
            "Bali, Indonesia",
            "New York, USA",
            1
        )


        questionList.add(que14)

        val que15 = Question(
            15,
            "What is the name of this dog breed?",
            R.drawable.quiz_q15,
            "Begal",
            "German Shepherd",
            "Golden Retriever",
            "Husky",
            1
        )


        questionList.add(que15)

        val que16 = Question(
            16,
            "What is the name of this coffee shop brand?",
            R.drawable.quiz_q16,
            "Tchibo",
            "Starbucks",
            "Coffee Cafe Day",
            "Stumptown Coffee Roasters",
            2
        )


        questionList.add(que16)

        val que17 = Question(
            17,
            "What is the name of this extinct flightless bird?",
            R.drawable.quiz_q17,
            "Dodo",
            "Momo",
            "Toto",
            "Soso",
            1
        )


        questionList.add(que17)

        val que18 = Question(
            18,
            "What is the approximate value of this mathematical constant?",
            R.drawable.quiz_q18,
            "1.32",
            "2.79",
            "3.14",
            "2.33",
            3
        )


        questionList.add(que18)
        return questionList
    }
}