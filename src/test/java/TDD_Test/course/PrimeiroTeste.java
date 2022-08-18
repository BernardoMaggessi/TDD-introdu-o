package TDD_Test.course;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PrimeiroTeste {
	
	@Mock
    Calculadora calculadora;

    @BeforeEach
    public void setUp(){
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomar2Numeros(){
        //cenario
        int numero1 = 10, numero2 = 5;

        //execução
        int resultado = calculadora.somar(numero1,numero2);

        //verificação
        Assertions.assertThat(resultado).isEqualTo(15);

    }

    @Test
    public void naoDeveSomarNumerosNegativos(){
        //cenario
        int num = -10, num2 = 5;

        //execução
        org.junit.jupiter.api.Assertions
        	.assertThrows(RuntimeException.class,() -> calculadora.somar(num, num2));
    }
    @Test
    public void deveSubtrair2Numeros() {
    	//cenario
    	int num = 10, num2 = 5;
    	//execução
    	int resultado = calculadora.subtrair(num, num2);
    	//verificação
    	Assertions.assertThat(resultado).isEqualTo(5);
    }
    @Test
    public void deveDividir2Numeros(){
        //cenario
        int num = 10, num2 = 5;
        //execução
        int resultado = calculadora.dividir(num,num2);
        //verificação
        Assertions.assertThat(resultado).isEqualTo(2);
    }
    @Test
    public void naoDeveDividirPorZero(){
        //cenario
        int num = 5,num2 =0;
        
        org.junit.jupiter.api.Assertions
        	.assertThrows(RuntimeException.class,() -> calculadora.dividir(num, num2));
    }
    @Test
    public void deveMultiplicar2numeros() {
        //cenario
        int num = 2,num2 = 5;
        //execução
        int resultado = calculadora.multiplicar(num,num2);

        Assertions.assertThat(resultado).isEqualTo(10);
    }
}

class Calculadora{
    int somar(int num, int num2){
        if(num<0||num2<0){
            throw new RuntimeException("Não é possivel somar numeros negativos");
        }
        return num+num2;
    }
    int dividir(int num, int num2){
        if(num2 == 0){
            throw new RuntimeException("não é possivel dividir por zero");
        }
        return num/num2;
    }
    int multiplicar(int num, int num2){
        return num*num2;
    }
    int subtrair(int num, int num2) {
    	return num-num2;
    }
}
