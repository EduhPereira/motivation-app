package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants
import kotlin.random.Random

class Phrase (val description: String, val categoryId: Int)

class Mock {
    private val allInclusive: Int = MotivationConstants.CATEGORY.ALL_INCLUSIVE
    private val happy: Int = MotivationConstants.CATEGORY.HAPPY
    private val sunny: Int = MotivationConstants.CATEGORY.SUNNY

    private val mListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez", happy),
        Phrase("Você não é derrotado quando perde, mas sim quando desiste!", happy),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente", happy),
        Phrase("Não pare quando estiver cansado, pare quanto tiver terminado", happy),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy),
        Phrase("A melhor maneira de prever o futuro é inventá-lo", sunny),
        Phrase("Você perde todas as chances que você não aproveita", sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso", sunny),
        Phrase("Enquanto não estivermos compremetidos, haverá hesitação!", sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve", sunny),
        Phrase("Se você acredita, faz toda a diferença", sunny)
    )

    fun getPhrase(category: Int): String{
        var phrase: String = ""

        if(category == allInclusive){
            phrase = mListPhrase[Random.nextInt(0, mListPhrase.size)].description
        }

        if(category == happy){
            val filteredList = mListPhrase.filter { it.categoryId == category }
            phrase = filteredList[Random.nextInt(0, filteredList.size)].description
        }

        if(category == sunny){
            val filteredList = mListPhrase.filter { it.categoryId == category }
            phrase = filteredList[Random.nextInt(0, filteredList.size)].description
        }

        return phrase
    }
}