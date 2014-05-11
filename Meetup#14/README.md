## MEETUP 14

#### Introdução

Nesse Meetup, eu construí junto com vocês uma pequena aplicação para mostrar um pouco do fluxo de trabalho no Android Studio, bem como para ilustrar alguns conceitos e ferramentas que ajudam o desenvolvedor no dia-a-dia.

A título de referência, nós vimos inicialmente como criar um projeto no Android Studio, e acredito que tenha ficado claro que é um procedimento bastante tranquilo.

Vimos como adicionar uma dependência externa no projeto via Gradle. No caso, escolhi mostrar a biblioteca [ButterKnife](http://jakewharton.github.io/butterknife/), que utilizo para eliminar um pouco da burocracia para obter referências para Views e mesmo para adicionar processamento de eventos.

Também mostrei uma ferramenta bastante útil para o desenvolvedor que é o [Android Asset Studio](http://android-ui-utils.googlecode.com/hg/asset-studio/dist/index.html). Com ela, nós vimos como gerar facilmente estilos customizados para a ActionBar da aplicação, bem como gerar ícones de interesse e mesmo imagens *9Patch*.

Ao final, conseguimos gerar uma aplicação simples, capaz de sortear algumas perguntas de forma aleatória. Eu adicionei algumas coisas na aplicação e seguindo as sugestões da galera, deixo também alguns pontos para que os interessados em aprender um pouco mais sigam e se divirtam. :)

#### TO DO (Nível Básico)

* Nesse projeto, as perguntas que são sorteadas aleatoriamente residem no arquivo **res/values/questions.xml**. São perguntas básicas sobre os fundamentos que devemos ter quando criamos aplicações para Android. Para quem se interessar, acesse esse arquivo e responda esse questionário, encaminhando as respostas no meu email **(ubiratan.f.soares | gmail.com)** e na primeira oportunidade que nos encontrarmos, farei questão de discutir com você em que pontos é possível melhorar quanto ao entendimento dos fundamentos da plataforma.

* Acrescente um novo arquivo XML de questões na aplicação, e faça com que a roleta de questões seja inicializada com as strings contidas nele. Escolha questões que aceitem resposta do tipo "Sim" ou "Não". 

* Altere o comportamento da classe **QuestionDialogFragment** para que esse exiba duas opções para as possíveis respostas da questão : "SIM" e "Não". Adicione *listeners* para processar esses eventos, mesmo que a princípio, seja apenas escrevendo alguma coisa no Logcat.

* Crie um sistema de pontos para a aplicação. Para isso, a cada resposta certa um contador de pontos deve ser incrementado de um. Utilize a biblioteca [Crouton](https://github.com/keyboardsurfer/Crouton ) para exibir os pontos atualizados (caso a resposta seja correta), adicionando a mesma no projeto via Gradle. Use também um Toast como uma mensagem simples caso a resposta esteja errada. Uma dica para começar essa tarefa de um modo bacana é : será que nosso modelo **Question** agora não deve conter mais alguma coisa de importante?

#### TO DO (Nível Avançado)

* Deixei na aplicação alguns métodos prontos para controlar o temporizador da roleta. Também deixei alguma coisa pronta para adicionar duas opções na ActionBar, sugerindo as ações de "Iniciar" e "Pausar". Obviamente, não está tudo na mão; mas ainda assim, faça com que a roleta seja controlável com ações via ActionBar.

* Com o item anterior executado, como proceder para a roleta esteja pausada enquanto o Dialog com a questão é exibido e ao mesmo tempo seja inicializada automaticamente após o mesmo ser desfeito? Repare que o estado do ícone da ActionBar deve se manter consistente durante a exibição do Dialog. Implemente essa funcionalidade.

* Implemente uma novo algoritmo em **QuestionsRoulette** para garantir que nunca uma questão é exibida antes que todas as outras tenham sido eventualmente exibidas; em outras palavras, as questões podem se repetir, mas somente quando todas as outras possíveis da rotela já tiverem sido exibidas (ainda que a escolha seja aleatória).

Bom galera, acho que é isso, abraços a todos e até a próxima!

// Bira


