package br.com;

import java.io.*;

class Funcionario {
    int id;
    String nome;
    String cargo;
    float salario;

    public Funcionario(int id, String nome, String cargo, float salario) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }
void adicionarFuncionario(File arquivo, Funcionario funcionario) throws IOException {
    RandomAccessFile raf = new RandomAccessFile(arquivo, "rw");
    raf.writeInt(funcionario.id);
    raf.writeUTF(funcionario.nome);
    raf.writeUTF(funcionario.cargo);
    raf.writeFloat(funcionario.salario);
    raf.close();
}
void atualizarFuncionario(File arquivo, Funcionario funcionario) throws IOException {
    RandomAccessFile raf = new RandomAccessFile(arquivo, "rw");
    boolean encontrado = false;
    long posicao = 0;
    while (posicao < raf.length() && !encontrado) {
        int id = raf.readInt();
        String nome = raf.readUTF();
        String cargo = raf.readUTF();
        float salario = raf.readFloat();
        Funcionario atual = new Funcionario(id, nome, cargo, salario);
        if (atual.id == funcionario.id) {
            encontrado = true;
            raf.seek(posicao);
            raf.writeInt(funcionario.id);
            raf.writeUTF(funcionario.nome);
            raf.writeUTF(funcionario.cargo);
            raf.writeFloat(funcionario.salario);
        }
        posicao += sizeof(Funcionario.class);
    }
    raf.close();
}
private long sizeof(Class<Funcionario> class1) {
    throw new UnsupportedOperationException("Unimplemented method 'sizeof'");
}
void excluirFuncionario(File arquivo, int id) throws IOException {
    RandomAccessFile raf = new RandomAccessFile(arquivo, "rw");
    boolean encontrado = false;
    long posicao = 0;
    File temp = new File("temp.bin");
    FileOutputStream fos = new FileOutputStream(temp);
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    while (posicao < raf.length() && !encontrado) {
        int idLido = raf.readInt();
        if (idLido == id) {
            encontrado = true;
        } else {
            bos.write(raf.readByte());
        }
        posicao += sizeof(Funcionario.class);
    }
    raf.close();
    bos.close();
    if (!encontrado) {
        System.out.println("Funcionario nao encontrado.");
    } else {
        temp.renameTo(arquivo);
    }
}
void listarFuncionarios(File arquivo) throws IOException {
    RandomAccessFile raf = new RandomAccessFile(arquivo, "r");
    long posicao = 0;
    while (posicao < raf.length()) {
        int id = raf.readInt();
        String nome = raf.readUTF();
        String cargo = raf.readUTF();
        float salario = raf.readFloat();
        Funcionario funcionario = new Funcionario(id, nome, cargo, salario);
        System.out.println(funcionario);
        posicao += sizeof(Funcionario.class);
    }
    raf.close();
}
}