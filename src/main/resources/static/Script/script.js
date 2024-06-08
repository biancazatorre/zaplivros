

document.getElementsByClassName('ordem').addEventListener('click', function () {
    toggleCategories('ordem');
});

function toggleCategories(id) {
    var ordem = document.querySelector('#' + id).nextElementSibling;
    ordem.style.display = (ordem.style.display === 'none') ? 'block' : 'none';
}




document.querySelectorAll('.seta').forEach(function (arrow) {
    arrow.addEventListener('click', function () {
        var ordem = this.nextElementSibling; // Selecionando o próximo irmão
        ordem.style.display = (ordem.style.display === 'none') ? 'block' : 'none'; // Alternando a exibição

        // Mudando a direção da seta
        if (this.innerHTML === '▶') {
            this.innerHTML = '▼'; // Mudando para seta para baixo
        } else {
            this.innerHTML = '▶'; // Mudando para seta para direita
        }
    });
});


window.addEventListener('load', function () {
    // Faz uma requisição AJAX para obter os dados dos funcionários
    fetch('/listar')
        .then(response => response.json())
        .then(data => {
            // Preenche a tabela com os dados recebidos
            const tabela = document.getElementById('tabelaFuncionarios');
            const tbody = tabela.querySelector('tbody');

            data.forEach(funcionario => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${funcionario.id}</td>
                    <td>${funcionario.nome}</td>
                    <td><a href="/dadosFunc/${funcionario.id}">Editar</a></td>
                `;
                tbody.appendChild(row);
            });
        })
        .catch(error => console.error('Erro ao obter os dados dos funcionários:', error));
});