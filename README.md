# EasyProcess
Aplicação para registrar processos judiciais afim de mantê-los organizados e de fácil acesso. O sistema permite cadastrar processos com seus respectivos tipos; informando número do processo, data de entrada, valor do recurso e objetivo podendo alterar e excluir os dados armazenados.

# Como usar a aplicação
1º Passo:
  - Criar o tipo de processo:

![image](https://user-images.githubusercontent.com/92529147/202013137-dc269f69-8b25-4d3b-b33e-71d7261f9202.png)

2º Passo:
  - Inserir o nome do tipo de processo:

![image](https://user-images.githubusercontent.com/92529147/202013689-af7fefa1-7c30-4afc-a7c8-6a03c6f046bc.png)

3º Passo:
  - Adicionar processo:

![image](https://user-images.githubusercontent.com/92529147/202014049-5b54c790-4377-4391-8948-8fc092122294.png)

⚠️ Não é possivel incluir um processo com o mesmo numero!

4º Passo:
  - Inserir dados do processo:

![image](https://user-images.githubusercontent.com/92529147/202014301-6cb4b4de-7a53-44e5-90d9-f6d6e3ab62bd.png)

5º Passo:
  - Consultar processos pelo numero:
 
 ![image](https://user-images.githubusercontent.com/92529147/202014791-4277ae6b-ba6e-4eac-8f21-5b819b989d20.png)

# Tecnologias Utilizadas
- JAVA 8
- Spring MVC 5.3.23
- servlet-api 2.4
- TomCat 8.5.83
- JSTL 1.2
- Spring JDBC 5.3.23
- ORACLE XE 11G-R2
- Maven 3.8
- Docker 20.10.21
- Docker compose v2.12.2
- IntelliJ IDEA 2022.2.3 (Community Edition)

# Como Executar o Projeto
1º Passo:
  Iniciar banco de dados com o comando:
  > docker-compose up oraclexe
  
⚠️ Aguarde o banco iniciar completamento e só depois vá para o proximo passo.

2º Passo:
  Executar a aplicação: 
  > docker-compose up --build easyprocess

⚠️ Observação:
  Para limpar container que não estão mais sendo utilizados e liberar espaço em disco na sua maquina rode o comando: 
  > docker system prune
  
# Banco de Dados
A estrutura do banco de dados ficou da seguinte forma:

  ![image](https://user-images.githubusercontent.com/92529147/202010208-b8874364-1213-4cd8-b173-7789a7b2f957.png)

Essa estrutura é criada pelo script [02-create-db-structure.sql](oraclexe/02-create-db-structure.sql)

