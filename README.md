# 🔧🤓👍🏾 Benezinho Assitência Técnica 

CP I - **Java Advanced** aplicado em 13/03/2024.


|![fiap.jpg](documentacao%2Ffiap.jpg)            | **Java Advanced** |
|------------------------------------------|-------------------|
| **ALUNO:**                               | **TURMA:** 2TDSPJ |
| **PROFESSOR:** Benefrancis do Nascimento | 13/03/2024        |
| **CP I**                      | ****              |

# Sumário


[Estudo de caso ](#_Estudo_de_caso)

[O que deverá ser feito? ](#_O_que_devera_ser_feito)

[Diagrama de Classes ](#_Diagrama_de_Classes)

[Como Entregar ](#_Entrega)

[Correção da Prova ](#_Correcao)

<a id="_Estudo_de_caso"></a>

# Estudo de caso


A Holding Benezinho está interessada em investir na abertura de Oficinas de Assistencia Tecnica Especialidada no Brasil em 2024. Este investimento pode oferecer diversas vantagens para o empresário, especialmente considerando o contexto econômico e social do país.  
 
Com o objetivo de fazer este negócio dar certo, idealizamos o desenvolvimento de um Sistema de Gestão de Chamados para a Assistencia Tecnica Especialidada.

Criaremos, nesta aula, um Produto Mínimo Viável (PMV) de uma API Rest para este sistema.



Nossa equipe de analistas desenvolveu o Diagrama de Classes abaixo, e a sua missão aqui é realizar o Mapeamento Objeto Relacional das classes de Entidade. Usaremos a JPA e o Hibernate como ferramentas de Mapeamento Objeto Relacional.

Na sprint atual, você foi incumbido de fazer:

1. O Mapeamento Objeto Relacional das primeiras classes envolvidas neste projeto de software;

2. A criação automatizada das tabelas no banco de dados Oracle;

3. A persistência de todos os dados, e;

4. A criação dos Seguintes Repositorios :

   1. ChamadoRepository
   2. EnderecoRepository
   3. TelefoneRepository
   4. EspecialidadeRepository
   5. OcorrenciaRepository
   6. SolicitanteRepository
   7. TecnicoRepository

5. A criação dos Seguintes Resources:

   1. **ChamadoResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/chamado" - **GET**;
      2. "localhost/chamado" - **POST**
      3. "logalhost/chamado/{id}" - **GET**
    
   2. **EspecialidadeResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/especialidade" - **GET**;
      2. "localhost/especialidade" - **POST**
      3. "logalhost/especialidade/{id}" - **GET**
      
   3. **OcorrenciaResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/ocorrencia" - **GET**;
      2. "localhost/ocorrencia" - **POST**;
      3. "logalhost/ocorrencia/{id}" - **GET**

   4. **SolicitanteResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/solicitante" - **GET**;
      2. "localhost/solicitante" - **POST**;
      3. "logalhost/solicitante/{id}" - **GET**;
      4. "logalhost/solicitante/{id}/endereco" - **GET**
      5. "logalhost/solicitante/{id}/telefone" - **POST**;
      6. "logalhost/solicitante/{id}/telefone" - **GET**
      7. "logalhost/solicitante/{id}/endereco" - **POST**
     
   5. **TecnicoResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/tecnico" - **GET**;
      2. "localhost/tecnico" - **POST**;
      3. "logalhost/tecnico/{id}" - **GET**;
      4. "logalhost/tecnico/{id}/especialidade - **POST**


<a id="_O_que_devera_ser_feito"></a>

# O que deverá ser feito?


**Você deverá:**

**Fazer o fork do projeto do github.**:

[https://github.com/Benefrancis/spring-pj-chamados-tecnicos](https://github.com/Benefrancis/spring-pj-chamados-tecnicos)

Caso o github esteja indisponível, você deverá pegar o projeto no diretório compartilhado.

Alterar o arquivo contido em  **documentacao/equipe.txt** para incluir os RMs e nomes e turma da dupla que fará esta atividade.

**OBS:** Será com base nos nomes contidos neste aquivo que eu irei atribuir a nota.

1. **(0,5 Ponto)** acessar o arquivo **application.yml** e incluir as configurações para **persistencia** para que seja possível conectar-se ao banco de dados Oracle da FIAP com o seu usuário e senha (manter o seu usuário e senha ativo é sua responsabilidade). Não utilize o usuário e senha de outro aluno. Caso tenha problema para autenticar, comunique o professor.

## **(4 Pontos)** No pacote entity, criar as seguintes classes e adicionar corretamente as anotações JPA

2. **(1 Pontos) Chamado**.

3. **(0,5 Ponto) Endereco**.

4. **(0,5 Ponto) Telefone**.

5. **(0,5 Ponto) Especialidade**.

6. **(0,5 Ponto) Ocorrencia**.

7. **(0,5 Ponto) Solicitante**.

8. **(0,5 Ponto) Tecnico**.


## 9 **(7,75 Ponto)** A perfeita criação dos Seguintes Resources no pacote resources

   1. **(1 Ponto) ChamadoResource** com as seguintes ROTAS e VERBOS:
      1. **(0,25 Ponto)** "localhost/chamado" - **GET**;
      2. **(0,50 Ponto)** "localhost/chamado" - **POST**
      3. **(0,25 Ponto)** "logalhost/chamado/{id}" - **GET**

   2. **(1 Ponto) EspecialidadeResource** com as seguintes ROTAS e VERBOS:
      1. **(0,25 Ponto)** "localhost/especialidade" - **GET**;
      2. **(0,50 Ponto)** "localhost/especialidade" - **POST**
      3. **(0,25 Ponto)** "logalhost/especialidade/{id}" - **GET**

   3. **(1 Ponto) OcorrenciaResource** com as seguintes ROTAS e VERBOS:
      1. **(0,25 Ponto)** "localhost/ocorrencia" - **GET**;
      2. **(0,50 Ponto)** "localhost/ocorrencia" - **POST**;
      3. **(0,25 Ponto)** "logalhost/ocorrencia/{id}" - **GET**

   4. **(3 Ponto) SolicitanteResource** com as seguintes ROTAS e VERBOS:
      1. **(0,25 Ponto)** "localhost/solicitante" - **GET**;
      2. **(0,50 Ponto)** "localhost/solicitante" - **POST**;
      3. **(0,25 Ponto)** "logalhost/solicitante/{id}" - **GET**;
      4. **(0,25 Ponto)** "logalhost/solicitante/{id}/endereco" - **GET**
      5. **(0,75 Ponto)** "logalhost/solicitante/{id}/telefone" - **POST**;
      6. **(0,25 Ponto)** "logalhost/solicitante/{id}/telefone" - **GET**
      7. **(0,75 Ponto)** "logalhost/solicitante/{id}/endereco" - **POST**

   5. **(1,75 Ponto) TecnicoResource** com as seguintes ROTAS e VERBOS:
      1. **(0,25 Ponto)** "localhost/tecnico" - **GET**;
      2. **(0,50 Ponto)** "localhost/tecnico" - **POST**;
      3. **(0,25 Ponto)** "logalhost/tecnico/{id}" - **GET**;
      4. **(0,75 Ponto)** "logalhost/tecnico/{id}/especialidade - **POST**                                                            


## 7. **(1,75 Ponto)** No pacote repository criar as seguintes interfaces

   1. **(0,25 Ponto)** ChamadoRepository
   2. **(0,25 Ponto)** EnderecoRepository
   3. **(0,25 Ponto)** TelefoneRepository
   4. **(0,25 Ponto)** EspecialidadeRepository
   5. **(0,25 Ponto)** OcorrenciaRepository
   6. **(0,25 Ponto)** SolicitanteRepository
   7. **(0,25 Ponto)** TecnicoRepository


<a id="_Diagrama_de_Classes"></a>

# Diagrama de Classes


![diagrama-de-classe-chamado-tecnico.png](documentacao%2Fdiagrama-de-classe-chamado-tecnico.png)

 

<a id="_Entrega"></a>

# Como Entregar

**A entrega deverá ser feita pelo Teams**, porém não se esqueça de fazer o **commit** e **push** do projeto no github.


<a id="_Correcao"></a>

# Correção da Prova

Nos próximos dias, a correção da prova será disponibilizada no github do professor (branch correcao):

Para acessar digite no prompt:

```shell
git clone https://github.com/Benefrancis/spring-pj-chamados-tecnicos && cd spring-pj-chamados-tecnicos && git checkout correcao
```


A atividade é em **DUPLA**, não se esqueça de colocar o nome dos integrantes no arquivo contido em documentacao/equipe.txt. Em caso de fraude de qualquer tipo, todos os envolvidos receberão nota ZERO.


Boa avaliação.
