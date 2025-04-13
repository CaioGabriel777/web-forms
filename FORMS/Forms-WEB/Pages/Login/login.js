async function fazerLogin() {
    const email = document.getElementById("email").value.trim();
    const senha = document.getElementById("senha").value.trim();

    if (!email || !senha) {
        alert("Preencha todos os campos.");
        return;
    }

    const credenciais = {
        email: email,
        senha: senha
    };

    try {
        //!ambiente de produção:
        const response = await fetch("https://web-forms-t5o7.onrender.com/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(credenciais)
        });

        if (response.ok) {
            if (response.ok) {
                localStorage.setItem("logado", "true"); // ou salvar token se tiver auth de verdade
                window.location.href = "/pages/admin/admin.html";
            }
        } else {
            alert("Email ou senha inválidos.");
        }
    } catch (error) {
        console.error("Erro detectado:", error.message);
        window.location.href = '/pages/error/erro.html';
    }
}
