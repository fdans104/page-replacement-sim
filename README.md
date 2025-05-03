# Page Replacement Algorithm Simulator – Simulador de Algoritmos de Substituição de Páginas

## English

This project presents the development of a simulator to evaluate the performance of different page replacement algorithms used in virtual memory management systems. The goal is to analyze, through simulation, the efficiency of each strategy in handling memory, by observing how many page faults occur while accessing a sequence of pages.

The project implements four classic algorithms: FIFO (First-In, First-Out), LRU (Least Recently Used), Clock (Second Chance), and Aging. Each algorithm uses a different approach to determine which page should be removed from memory when a new one needs to be loaded.

- The **FIFO** algorithm always replaces the oldest page — the one that entered memory first.
- **LRU** removes the page that has not been used for the longest time, requiring tracking of usage order.
- The **Clock** algorithm is an optimized version of FIFO: it uses a circular pointer and reference bits to give recently accessed pages a "second chance."
- The **Aging** algorithm is a software-based alternative to LRU. It uses aging counters to estimate how long it has been since each page was last accessed, and replaces the ones with the lowest counters.

All source code files include comments in English explaining how each algorithm works and how the simulation is structured.

To run the simulator, simply compile the `.java` files and run the `Main` class, which invokes the algorithms on a fixed sequence of page references. The output displays the number of page faults for each strategy. The simulator is expected to provide insights into the relative performance of the algorithms, helping assess which ones are more suitable for different scenarios and memory access patterns.

### How to run

1. Compile the `.java` files:  
   In the terminal, navigate to the folder containing the files and run:
   ```bash
   javac *.java
   ```

2. Run the main class `Main`:  
   ```bash
   java Main
   ```

3. (Optional) Edit the `Main` class to modify the page reference sequence or the simulated memory size.

---

## Português

Este projeto apresenta o desenvolvimento de um simulador para avaliar o desempenho de diferentes algoritmos de substituição de páginas utilizados em sistemas de gerenciamento de memória virtual. O objetivo é analisar, por meio da simulação, a eficiência de cada estratégia na gestão da memória, observando quantas faltas de página ocorrem durante o acesso a uma sequência de páginas.

O projeto implementa quatro algoritmos clássicos: FIFO (First-In, First-Out), LRU (Least Recently Used), Clock (Segunda Chance) e Aging (Envelhecimento). Cada algoritmo possui uma abordagem distinta para determinar qual página deve ser removida da memória quando uma nova página precisa ser carregada.

- O algoritmo **FIFO** sempre substitui a página mais antiga, ou seja, aquela que entrou primeiro na memória.
- O **LRU** remove a página que não foi utilizada há mais tempo, exigindo o rastreamento da ordem de uso.
- O **Clock** é uma variação otimizada do FIFO: utiliza um ponteiro circular e bits de referência para oferecer uma "segunda chance" às páginas acessadas recentemente.
- O **Aging** é uma alternativa ao LRU, implementada em software. Utiliza contadores de envelhecimento para estimar quanto tempo se passou desde o último acesso a cada página, substituindo aquelas com os menores contadores.

Todos os arquivos do código-fonte incluem comentários em inglês, explicando como cada algoritmo funciona e como a simulação está estruturada.

Para executar o simulador, basta compilar os arquivos `.java` e executar a classe `Main`, que invoca os algoritmos sobre uma sequência fixa de referências a páginas. A saída do programa exibe o número de faltas de página ocorridas com cada estratégia. Espera-se que o simulador forneça insights sobre o desempenho relativo dos diferentes algoritmos, permitindo avaliar quais são mais adequados para diferentes cenários e padrões de acesso à memória.

### Como executar

1. Compile os arquivos `.java`:  
   No terminal, navegue até o diretório onde estão os arquivos e execute:
   ```bash
   javac *.java
   ```

2. Execute a classe principal `Main`:  
   ```bash
   java Main
   ```

3. (Opcional) Edite a classe `Main` para modificar a sequência de páginas ou o tamanho da memória simulada.
