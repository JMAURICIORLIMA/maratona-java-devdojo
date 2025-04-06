Desafio do **Diário do Programador** 😎

## ✨ **Nova versão: Entrada personalizada pelo usuário + frase aleatória**

Agora o programa:
1. Mostra uma frase aleatória de reflexão.
2. Pede para o usuário escrever sua própria entrada.
3. Grava tudo (data, frase aleatória e entrada do usuário) no arquivo `diario.txt`.

---

## 🛠️ **Passo a passo do que vamos fazer:**

1. Criar um vetor com frases motivacionais.
2. Sortear uma delas aleatoriamente.
3. Usar `Scanner` para receber o que o usuário quer escrever.
4. Escrever no arquivo com `BufferedWriter`, formatando tudo com data/hora.

---

### 🧾 Exemplo de saída no console:
```
💡 Frase do dia: Persistência compila resultados.
✏️ Escreva sua reflexão de hoje: Hoje venci um bug que me perseguiu por horas!

✅ Entrada adicionada com sucesso!
```

### 📄 Exemplo do conteúdo em `diario.txt`:
```
📅 [30/03/2025 15:42:22]
💭 Frase do dia: Persistência compila resultados.
📝 Reflexão: Hoje venci um bug que me perseguiu por horas!
-----------------------------------------------------
```

---

## 🔧 Ideias de expansão (se quiser ir além):

- Salvar o diário com nome por data: `diario_2025_03_30.txt`
- Permitir visualizar as entradas anteriores.
- Gerar um resumo das entradas no fim do mês.