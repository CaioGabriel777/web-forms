document.addEventListener("DOMContentLoaded", () => {
    const logado = localStorage.getItem("logado");

    if (logado !== "true") {
        window.location.href = "/pages/login/login.html";
    }
});
async function buscarClientes() {
    const nomeCliente = document.getElementById("nomeCliente").value;

    if (!nomeCliente.trim()) {
        alert("Digite um nome para buscar.");
        return;
    }

    try {
        //!ambiente de desenvolvimento:
        //const response = await fetch(`https://localhost:8080/cliente/buscar/${encodeURIComponent(nomeCliente)}`);

        //!ambiente de produção:
        const response = await fetch(`https://web-forms-t5o7.onrender.com/cliente/buscar/${encodeURIComponent(nomeCliente)}`);
        const clientes = await response.json();
        document.getElementById("limparBusca").style.display = "inline";

        if (clientes.length === 0) {
            alert("Nenhum cliente encontrado.");
            return;
        }

        exibirClientes(clientes); 

    } catch (error) {
        console.error("Erro ao buscar clientes:", error);
        alert("Erro ao buscar clientes.");
    }
}

function limparBusca() {
    document.getElementById("nomeCliente").value = "";
    document.getElementById("limparBusca").style.display = "none"; 
    buscarTodosClientes(); 
}

async function buscarTodosClientes() {
    try {
        //!ambiente de desenvolvimento:
        //const response = await fetch("https://localhost:8080/cliente/todos");
        
        //!ambiente de produção:
        const response = await fetch("https://web-forms-t5o7.onrender.com/cliente/todos");
        const clientes = await response.json();
        exibirClientes(clientes);
    } catch (error) {
        console.error("Erro ao buscar todos os clientes:", error);
    }
}

function exibirClientes(clientes) {
    const corpoTabela = document.getElementById("corpoTabelaClientes");
    corpoTabela.innerHTML = "";

    if (clientes.length === 0) {
        const linha = document.createElement("tr");
        const celula = document.createElement("td");
        celula.colSpan = 8;
        celula.textContent = "Nenhum cliente encontrado.";
        linha.appendChild(celula);
        corpoTabela.appendChild(linha);
        return;
    }

    clientes.forEach(cliente => {
        const linha = document.createElement("tr");

        linha.innerHTML = `
            <td>${cliente.id}</td>
            <td>${cliente.nome}</td>
            <td>${cliente.email}</td>
            <td>${cliente.modelo}</td>
            <td>${cliente.cpf}</td>
            <td>${cliente.rg}</td>
            <td>${cliente.cep}</td>
            <td>${cliente.estadoCivil}</td>
            <td>${<button onclick="excluirCliente(${cliente.id})" 
                 style="background:none;border:none;font-size:18px;color:red;cursor:pointer;">❌</button>}</td>
        `;

        corpoTabela.appendChild(linha);
    });
}

async function excluirCliente(id) {
    if (!confirm("Tem certeza que deseja excluir este cliente?")) return;

    try {
        const response = await fetch(`https://web-forms-t5o7.onrender.com/cliente/excluir/${id}`, {
            method: "DELETE"
        });

        if (response.ok) {
            alert("Cliente excluído com sucesso!");
            buscarTodosClientes(); 
        } else {
            alert("Erro ao excluir cliente.");
        }
    } catch (error) {
        console.error("Erro ao excluir cliente:", error);
        alert("Erro ao excluir cliente.");
    }
}

window.onload = () => {
    buscarTodosClientes();
};
