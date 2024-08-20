public class Racional {
    
    int numerador;
    int denominador;
    
     public Racional(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
        }
     
        // Constructor sin argumentos
        public Racional() {
           this(1, 1); // Valores por defecto 1/1
        }
     
      private void simplificar() {
        int mcd = calcularMCD(numerador, denominador);
        numerador /= mcd;
        denominador /= mcd;
      }
       private int calcularMCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calcularMCD(b, a % b);
    }
     
     // Operaciones aritméticas
    public Racional sumar(Racional racional2) {
        int nuevoNumerador = this.numerador * racional2.denominador + racional2.numerador * this.denominador;
        int nuevoDenominador = this.denominador * racional2.denominador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    public Racional restar(Racional racional2) {
        int nuevoNumerador = this.numerador * racional2.denominador - racional2.numerador * this.denominador;
        int nuevoDenominador = this.denominador * racional2.denominador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    public Racional multiplicar(Racional racional2) {
        int nuevoNumerador = this.numerador * racional2.numerador;
        int nuevoDenominador = this.denominador * racional2.denominador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    public Racional dividir(Racional racional2) {
        int nuevoNumerador = this.numerador * racional2.denominador;
        int nuevoDenominador = this.denominador * racional2.numerador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Métodos para impresión
    public float decimal() {
        return (float) numerador / denominador;
    }
    
    public String decimal(int precision) {
        return String.format("%." + precision + "f", (float) numerador / denominador);
    }
    
    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
}