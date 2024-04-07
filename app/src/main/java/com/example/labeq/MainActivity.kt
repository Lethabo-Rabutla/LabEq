package com.example.labeq
-
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType.Companion.Number
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labeq.ui.theme.LabEqTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabEqTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LabEq("10-140")
                }
            }
        }
    }
}

@Composable
fun LabEq(labName: String) {
    var computers by remember { mutableStateOf(0) }
    var screens by remember { mutableStateOf(0) }
    var keyboards by remember { mutableStateOf(0) }
    var totalValue by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        OutlinedTextField(
            value = computers.toString(),
            onValueChange = { computers = it.toIntOrNull() ?: 0 },
            label = { Text("Computers") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = Number)
        )
        Spacer(modifier = Modifier.height(1.dp))

        OutlinedTextField(
            value = screens.toString(),
            onValueChange = { screens = it.toIntOrNull() ?: 0 },
            label = { Text("Screens") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = Number)
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = keyboards.toString(),
            onValueChange = { keyboards = it.toIntOrNull() ?: 0 },
            label = { Text("Keyboards") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = Number)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                totalValue = (computers * 5000) + (screens * 2000) + (keyboards * 200)
            }
        ) {
            Text("Calculate Total Value")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Total Lab Assets Value for $labName: R$totalValue")
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LabEqTheme {
        LabEq(labName = "10-140")
    }
}