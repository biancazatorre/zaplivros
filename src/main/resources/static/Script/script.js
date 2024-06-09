

    document.getElementsByClassName('ordem').addEventListener('click', function() {
        toggleCategories('ordem');
    });

    function toggleCategories(id) {
        var ordem = document.querySelector('#' + id).nextElementSibling;
        ordem.style.display = (ordem.style.display === 'none') ? 'block' : 'none';
    }



    
document.querySelectorAll('.seta').forEach(function(arrow) {
    arrow.addEventListener('click', function() {
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
