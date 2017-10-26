## Teste bubblesort - PBL de SD 2017.1
## Grupo: Washington Pagotto Batista, Pedro Kenndy e Ivan
.data

	        .equ UART0, 0x860       #porta Serial Uart0
		#armazenando o valor na word e printando uma mensagem
		
		resultado:  
		.word 0
		
		msgResultado:
		.asciz "Resultado: "

.text
main:	        movia r5, UART0
		call nr_uart_rxchar  #macro que ler o que � enviado pelo uart0
		blt r2, r0, main
		
	        subi r6, r2, 48      #pega o valor que foi digitado e subtrai por -48( por causa da tabela asc)
	        movia r8, 46         #armazena o primeiro valor inserido 
		
loop:         	movia r9,46          #em asc o numero 46 representa um Ponto " . "
	      	beq r9, r2, inicia     #caso exista o valor digitado seja 46 terminou o numero inserido e inicia o calculo
              	movia r4, UART0
	      	call nr_uart_rxchar  #macro que ler o que � enviado ... 0 a 9
	      	blt r2, r0, loop     
	       
	       	beq r9, r2, inicia   
	     
	      
ascParaDec:     mov r7, r2           #passa o valor atual para o r7 temporario
	        muli r6, r6, 10      #Pegar o valor inserido e multiplica por 10 para aceita a concatena��o de outro numero
	        subi r7, r7, 48      #vamos que ir� concatenar -48 por causa da tabela asc
	        add r6, r6, r7       #cocatena os valores atraves da soma 
	        br loop 	

inicia:
		mov r3, r6           #recebe o valor inserido pela entrada serial
		movi r13, 1          #inicio da multiplica��o
		call fatorial        
		br fim

    	 
fatorial:
		
		subi sp, sp, 8   #dividindo a pilha em endere�o e o valor
      		stw ra, 4(sp)    #endere�o de retorno 
      		stw r3, 0(sp)    #o valor
      		
      		movi r7, 1       #Inicia para a compara��o
      		              
      		cmpgt r8, r7, r3            # verifica se r7 � maior que r3 ele pode continua at� chegar em 1
     		beq r8, r0, fatorial_return  # Se for maior � entao ele precisa chamar a proxima recursao 

		
     	  	addi sp, sp, 8  	# Libera tudo da 
     		jmp ra  	        # transfere a execu��o para RA .. ou seja o endere�o de retorno 

Libera:
	        ldw r3, 0(sp)  	 	#fazendo leitura da pilha 
    	  	ldw ra, 4(sp)  	 	#pegando os endere�os 
     		addi sp, sp, 8          #incrementando para percorrer a pilha
     		
Resultado:
 		mul r13, r3, r13        #multiplica��o
     		jmp ra 	                #retorno do enrede�o
     		br fim
     		
fatorial_return:   
		subi r3, r3, 1   	# Fica decrementando a cada chamada
     	  	call fatorial           #executa para que a proxima execu��o seja (n-1) at� terminar a pilha

        	br Libera
   
fim:

		
		movia r9, resultado     #move a word
		stw r13, 0(r9)		#pega o enderesso que est� no r9 e altera o seu valor para resultado 
		movia r4, msgResultado  #printa a mensagem para o resultado
		movia r5, UART0		
		call nr_uart_txstring	#Macro que ler uma string 
		mov r4, r13		
		movia r5, UART0		
		call nr_uart_txhex32  #Pega o resultado e joga para macro que ler em hexadecimal 
		
