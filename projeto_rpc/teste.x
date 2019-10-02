struct operands{
    int x; 
    int z;
};


program SIMP_PROG{
	version SIMP_VERSION{
		int soma(operands)=1;
		int subtracao(operands)=2;
		int divisao(operands)=3;
		int multiplicacao(operands)=4;
		int maior(operands)=5;
		int menor(operands)=6;
		int porcentagem(operands)=7;
	} = 1;
} = 0x2fffffff;
