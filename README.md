# Simulação de Padrões de Aterrissagem e Decolagem em Aeroporto
## Descrição
Este projeto simula o gerenciamento de padrões de aterrissagem e decolagem em um aeroporto com três pistas e filas de espera para aeronaves. A simulação controla o fluxo de aeronaves que chegam e partem, garantindo que as filas de espera sejam balanceadas para evitar sobrecarga.

## Funcionalidades
Pistas e Filas:

### Três pistas (1, 2 e 3): Pistas 1 e 2 para aterrissagem; pista 3 para decolagem e pouso emergencial.
Duas filas de espera para aterrissagem em cada uma das pistas 1 e 2; uma fila de espera para decolagem em cada pista.
Filas de espera balanceadas para manter o máximo de 1 unidade de diferença no tamanho.
Processamento por Unidade de Tempo:

### Em cada unidade de tempo, de 0 a 3 aeronaves podem entrar nas filas de aterrissagem e decolagem, com ID e combustível disponível (para aterrissagem).
Aviões com combustível insuficiente recebem prioridade de pouso na pista 3.
Decolagens e aterrissagens são processadas após a entrada de aeronaves nas filas.
Métricas e Relatórios:

### Exibe o conteúdo das filas periodicamente.
Calcula e imprime:
Tempo médio de espera para decolagem e aterrissagem.
Número de pousos realizados sem reserva de combustível.
Número de quedas devido à falta de combustível.
Entrada e Geração de Dados
O programa utiliza um gerador de números aleatórios para definir:

O número de aeronaves chegando nas filas de aterrissagem (0 a 3) e de decolagem (0 a 3) em cada unidade de tempo.
O combustível restante das aeronaves na fila de aterrissagem (1 a 20 unidades).
