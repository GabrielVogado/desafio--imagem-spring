
# Desafio Mirante - C&A





# Criterios de Aceite

###  Uma aplicação spring boot baseada em arquitetura hexagonal (modularizada , opcional ) para upload e download de imagens
- O projeto deve conter um endpoint para download (nome)
- O projeto deve conter um endpoint para upload
- O projeto deve conter uma Porta para Download e Upload
- O projeto deve conter 2 adaptadores dessa porta 
- Um adaptador IMG_LOCAL que salva e busca as imagens na memória local do servidor 
- Utilizar uma pasta no disco rígido 
- Um adaptador IMG_DB para salvar e buscar imagens no banco de dados (H2)
- salva a imagem em Base64
- O projeto deve selecionar o adaptador baseado no profile de configuração do projeto 
	* IMG_LOCAL : profile = local
	* IMG_DB : profile != local


## Documentação da API

#### Upload de Imagem

```http
  POST /images/upload
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `file` | `MultipartFile` |  A chave da sua API |

No Postman, vé em Body, selecione a opção form-data e no campo chave, selecione a opção FILE

#### Download da Imagem

```http
  GET /images/download/{imageName}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `imageName`      | `string` |  O Nome da Imagem que você quer |




## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no seu profiles

`Local` para poder subir no perfil local, onde sera salvo a imagem no sua maquina de destino descrito na variavel `LOCAL_PATH` da classe `ImageLocalServiceImpl` -  C:/Users/[User]/Downloads/";



`Default` por padrão o projeto subira para salvar a imagem em um banco de memoria H2



### Ativando perfil Local

https://th.bing.com/th/id/OIP.bxAVhBfVwMhAKM6T0KBCYQAAAA?rs=1&pid=ImgDetMain


### Alterando Form-Data postman

https://th.bing.com/th/id/OIP.7r1Gk26vj5_YlWdzRUCZrgHaDN?rs=1&pid=ImgDetMain
