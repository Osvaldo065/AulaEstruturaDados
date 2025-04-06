// Na sua Activity
private NavegadorWeb navegador = new NavegadorWeb();

// No onClick do botão de voltar
public void onClickVoltar(View view) {
    navegador.voltar();
    atualizarPagina();
}

// No onClick do botão de avançar
public void onClickAvancar(View view) {
    navegador.avancar();
    atualizarPagina();
}

// Para visitar nova página
public void visitarNovaPagina(String url) {
    navegador.visitarPagina(url);
    atualizarPagina();
}

private void atualizarPagina() {
    textViewPaginaAtual.setText(navegador.getPaginaAtual());
    // Atualizar estado dos botões (habilitar/desabilitar)
    buttonVoltar.setEnabled(!navegador.getHistoricoVoltar().isEmpty());
    buttonAvancar.setEnabled(!navegador.getHistoricoAvancar().isEmpty());
}