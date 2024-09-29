<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora de Juros Compostos</title>
    <link rel="stylesheet" type="text/css" href="/styles/styling.css">
</head>

<body>
<div>
    <div class="painel">
        <h2>Calculadora de Juros Compostos</h2>
        <h3 class="erro">${erro != null ? erro : ""}</h3>
        <div>
            <form action="/" method="post">
                <div class="form-grid">
                    <label for="valorprincipal">Valor Principal: R$</label>
                    <input type="number" id="valorprincipal" name="valorprincipal" value="${valorPrincipal}" required>

                    <label for="juros">Taxa de Juros (%):</label>
                    <input type="number" id="juros" name="juros" min="1" max="100" value="${juros}" required>

                    <label for="anos">Número de Anos:</label>
                    <input type="number" id="anos" name="anos" min="1" value="${anos}" required>

                    <label for="periodocomposto">Vezes por Ano (1 a 12):</label>
                    <input type="number" id="periodocomposto" name="periodocomposto" min="1" max="12" value="${periodoComposto}" required>
                </div>

                <button type="submit">Calcular</button><br><br>

                <p class="resultado">Montante: R$ ${resultado != null ? String.format("%.2f", resultado) : "N/A"}</p>
                <p class="resultado">Juros: R$ ${jurosAcumulados != null ? String.format("%.2f", jurosAcumulados) : "N/A"}</p>
            </form>
        </div>
    </div>
</div>

</body>
</html>
