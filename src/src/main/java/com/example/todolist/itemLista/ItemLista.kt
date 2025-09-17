package com.example.todolist.itemLista

import android.icu.text.Transliterator.Position
import android.service.quickaccesswallet.WalletCard
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.todolist.model.Tarefa
import com.example.todolist.ui.theme.RB_GREEN
import com.example.todolist.ui.theme.RB_RED
import com.example.todolist.ui.theme.RB_YELLOW
import com.example.todolist.ui.theme.WHITE

@Composable
fun ItemLista(
    position: Int,
    listaTarefas: MutableList<Tarefa>
){
    val tituloTarefa = listaTarefas[position].tarefa
    val descricaoTarefa = listaTarefas[position].descricao
    val prioridade = listaTarefas[position].prioridade


    val nivelPriridade: String = when(prioridade){
        0 -> "baixa"
        1 -> "media"
        2 -> "alta"
        else -> "baixa"
    }
    val corPrioridade=when(prioridade){
        0 -> RB_GREEN
        1->  RB_YELLOW
        2 -> RB_RED
        else -> RB_GREEN
    }
    Card(
        modifier = Modifier
                   .fillMaxWidth()
                    .padding(20.dp),
        colors = CardDefaults.cardColors(WHITE)
    ) {
        Column (

        ){
            Text(
                tituloTarefa,
                modifier = Modifier.padding(20.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                descricaoTarefa,
                modifier = Modifier.padding(20.dp)

            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
            ){
                Text(
                    "prioridade",
                    modifier = Modifier.padding(0.dp,0.dp,20.dp,0.dp)
                )
                Card(
                    colors = CardDefaults.cardColors(corPrioridade)
                ) {
                    Box(
                        modifier = Modifier.padding(8.dp,4.dp),

                    ){
                        Text(
                            nivelPriridade,
                            textAlign = TextAlign.Center
                        )
                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier.padding(100.dp,0.dp,0.dp,0.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Icone de apagar",
                            tint = RB_RED
                        )
                    }
                }

            }
        }
    }
}