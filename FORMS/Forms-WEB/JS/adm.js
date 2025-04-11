async function buscarClientes() {
    const nomeCliente = document.getElementById("nomeCliente").value;

    if (!nomeCliente.trim()) {
        alert("Digite um nome para buscar.");
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/cliente/buscar/${encodeURIComponent(nomeCliente)}`);
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
        const response = await fetch("http://localhost:8080/cliente/todos");
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
            <td>${cliente.nome}</td>
            <td>${cliente.email}</td>
            <td>${cliente.modelo}</td>
            <td>${cliente.cpf}</td>
            <td>${cliente.rg}</td>
            <td>${cliente.orgaoExpedidor}</td>
            <td>${cliente.cep}</td>
            <td>${cliente.estadoCivil}</td>
        `;

        corpoTabela.appendChild(linha);
    });
}

window.onload = () => {
    buscarTodosClientes();
};
