#language: pt

Funcionalidade: Aprender Cucumber
	Como um aluno
	Eu quero aprender a utilizar Cucumber
	Para que eu possa automatizar critérios de aceitação

Cenário: Deve executar especificação
	Dado que criei o arquivo corretamente
	Quando executá-lo
	Então a especificação deve finalizar com sucesso
	
Cenário: Deve incrementar contador
	Dado que o valor do contador é 15
	Quando eu incrementar em 3
	Então o valor do contador será 18
	
Cenário: Deve incrementar contador
	Dado que o valor do contador é 123
	Quando eu incrementar em 3
	Então o valor do contador será 126
	
Cenário: Deve calcular atraso na entrega
	Dado que a entrega é dia 05/04/2018
	Quando a entrega atrasar em 2 dias
	Então a entrega será efetuada em 07/04/2018
	
Cenário: Deve calcular atraso na entrega da China
	Dado que a entrega é dia 05/04/2018
	Quando a entrega atrasar em 2 meses
	Então a entrega será efetuada em 05/06/2018
