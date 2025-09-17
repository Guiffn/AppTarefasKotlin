import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todolist.components.CaixaDeTexto
import com.example.todolist.ui.theme.Purple40
import com.example.todolist.ui.theme.RB_GREEN
import com.example.todolist.ui.theme.RB_RED
import com.example.todolist.ui.theme.RB_YELLOW
import kotlin.reflect.typeOf

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTarefas(navController: NavController) {

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Adicionar Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple40
                )
            )
        }
    ){
        var tituloTarefa by remember {
            mutableStateOf("")
        }
        var descricaoTarefa by remember {
            mutableStateOf("")
        }
        var prioridade by remember {
            mutableStateOf("baixa")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ){
            CaixaDeTexto(
                Modifier.fillMaxSize()
                    .padding(20.dp,100.dp,20.dp,0.dp),
                tituloTarefa,
                {
                  tituloTarefa = it
                },
                "Titulo da tarefa",
                1,
                KeyboardType.Text
            )
            CaixaDeTexto(
                Modifier.fillMaxSize().height(200.dp)
                    .padding(20.dp,20.dp,20.dp,0.dp),
                descricaoTarefa,
                {
                    descricaoTarefa = it
                },
                "Dercricao Tarefa",
                5,
                KeyboardType.Text
            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                Text("Prioridade:")

                //Baixa
                RadioButton(
                    selected = prioridade == "baixa",
                    onClick = {
                        prioridade = "baixa"
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RB_GREEN
                    )
                )
                RadioButton(
                    selected = prioridade == "media",
                    onClick = {
                        prioridade = "media"
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RB_YELLOW
                    )
                )
                RadioButton(
                    selected = prioridade == "alta",
                    onClick = {
                        prioridade = "alta"
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RB_RED
                    )
                )
            }
            Button(
                modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                            .height(80.dp),
                            colors = ButtonDefaults.buttonColors(Purple40),
                            onClick = {}
            ) {
                Text("Adicionar")
            }
        }
    }
}

@Preview
@Composable
private fun AddTarefaPreview() {
    AddTarefas(navController = rememberNavController())
}