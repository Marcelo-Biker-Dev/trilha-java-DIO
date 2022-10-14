package com.treinamento;

public class Conta {
    
    Integer numeroDeConta;
    String tipo;

    private Cliente cliente;

    public Conta(Integer numeroDeConta, String tipo, Cliente cliente) {
        this.numeroDeConta = numeroDeConta;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumeroDeConta() {
        return numeroDeConta;
    }

    public void setNumeroDeConta(Integer numeroDeConta) {
        this.numeroDeConta = numeroDeConta;
    }

    @Override
    public String toString() {
        return "Conta [numeroDeConta=" + numeroDeConta + ", tipo=" + tipo + ", cliente=" + cliente.getNome() + ", hashCode=" + this.hashCode() + "]";
    }

    public void imprime() {
        //return "Conta [numeroDeConta=" + numeroDeConta + ", tipo=" + tipo + ", cliente=" + cliente.getNome() + ", hashCode=" + this.hashCode() + "]";
        System.out.println("Conta [numeroDeConta=" + numeroDeConta + ", tipo=" + tipo + ", cliente=" + cliente.getNome() + ", hashCode=" + this.hashCode() + "]");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroDeConta == null) ? 0 : numeroDeConta.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        if (numeroDeConta == null) {
            if (other.numeroDeConta != null)
                return false;
        } else if (!numeroDeConta.equals(other.numeroDeConta))
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        return true;
    }


    
}
