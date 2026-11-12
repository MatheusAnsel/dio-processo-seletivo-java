# Processo Seletivo e Contador em Java

Desafio de projeto da DIO (trilha Santander 2024 - Backend com Java). Trabalhei com estruturas condicionais, laços de repetição e tratamento de exceções.

## 1. Sistema de validação de processo seletivo

`src/candidatura/ProcessoSeletivo.java`

Simula um processo seletivo com salário base de R$ 2.000,00:

- **Análise do candidato:** compara o salário pretendido com o salário base (`if / else if / else`).
  - Pretendido menor que o base: ligar para o candidato
  - Pretendido igual ao base: ligar com contraproposta
  - Pretendido maior que o base: aguardar os demais candidatos
- **Seleção:** percorre a lista de candidatos com `while`, gera um salário pretendido aleatório entre R$ 1.800 e R$ 2.200 e seleciona no máximo 5.
- **Impressão:** lista os selecionados com `for` indexado.
- **Contato:** simula até 3 tentativas de ligação para cada selecionado com `do-while`.

## 2. Contador com exceção personalizada

`src/contador/Contador.java` e `src/contador/ParametrosInvalidosException.java`

- Lê dois números inteiros pelo terminal (`Scanner`).
- Se o primeiro for maior que o segundo, lança `ParametrosInvalidosException` com a mensagem "O segundo parâmetro deve ser maior que o primeiro".
- Se estiver tudo certo, imprime a contagem da diferença entre os dois: "Imprimindo o número 1", "Imprimindo o número 2" etc.

## Como executar

Requisito: JDK 17 ou superior.

```bash
# compilar
javac -d out src/candidatura/*.java src/contador/*.java

# processo seletivo
java -cp out candidatura.ProcessoSeletivo

# contador
java -cp out contador.Contador
```

## Tecnologias

- Java
- `ThreadLocalRandom` para simular salários e ligações
- Exceções checadas personalizadas

## Autor

Matheus de Almeida Ansel
[LinkedIn](https://www.linkedin.com/in/matheusansel) | [GitHub](https://github.com/MatheusAnsel) | [Portfólio](https://matheusansel.pages.dev)
