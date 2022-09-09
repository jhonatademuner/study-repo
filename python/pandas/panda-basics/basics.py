
#$ |=======================================================================|
#$ |==========| Criando um dataframe a partir dde um dicionario |==========|
#$ |=======================================================================|
import pandas as pd
venda = {'data' : ['15/02/2021', '16/02/2021'],
        'valor' : [500, 300],
        'produto' : ['feijao' , 'arroz'],
        'qtd' : [50, 70]}
vendas_df = pd.DataFrame(venda)


#$ |==========================================|
#$ |==========| Visualizando dados |==========|
#$ |==========================================|

import pandas as pd
venda = {'data' : ['15/02/2021', '16/02/2021'],
        'valor' : [500, 300],
        'produto' : ['feijao' , 'arroz'],
        'qtd' : [50, 70]}
vendas_df = pd.DataFrame(venda)
print(vendas_df)
display(vendas_df) #@ Necessario rodar no jupyter



#$ |===========================================================|
#$ |==========| Importando arquivos e base de dados |==========|
#$ |===========================================================|

import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
display(vendas_df)



#$ |=============================================================|
#$ |==========| Visualizacao de dados simples e uteis |==========|
#$ |=============================================================|

#@ Exibe apenas as 10 primeiras linhas do dataframe
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
display(vendas_df.head(10))


#@ Exibe quantas linhas e colunas o dataframe possui
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
display(vendas_df.shape) 


#@ Exibe um "resumo" das colunas do dataframe (contagem, media, min, max, etc)
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
display(vendas_df.describe()) 



#$ |=======================================================|
#$ |==========| Selecionar colunas no dataframe |==========|
#$ |=======================================================|

#@ Dessa forma (selecionando apenas 1 coluna) a coluna vira um panda.series e nao um dataframe
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
produtos = vendas_df['Produto'] 
display(produtos)


#@ Dessa forma (selecionando mais de 1 coluna) a coluna vira um dataframe
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
produtos_lojas = vendas_df[['Produto', 'ID Loja']] 
display(produtos_lojas)



#$ |=====================================================================|
#$ |==========| Metodo .loc[linha, coluna] !!! IMPORTANTE !!! |==========|
#$ |=====================================================================|

#@ Como no topico anterior sera exibido um panda.series e nao um dataframe
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
display(vendas_df.loc[1])


#@ Nesse caso sera exibido um dataframe ja que mais de uma linha foi selecionada
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
display(vendas_df.loc[1 : 5]) 


#@ Seleciona apenas as linhas que cumprem a condicao definida
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
vendas_norteshopping_df = vendas_df.loc[vendas_df['ID Loja'] == 'Norte Shopping']
display(vendas_norteshopping_df)


#@ Selecionando linhas e colunas ao mesmo tempo no dataframe
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
vendas_norteshopping_df = vendas_df.loc[vendas_df['ID Loja'] == 'Norte Shopping', ['ID Loja', 'Produto', 'Quantidade']] 
display(vendas_norteshopping_df)


#@ Selecionando um valor especifico
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
print(vendas_df.loc[1, 'Produto']) 



#$ |===========================================|
#$ |==========| Criando nova coluna |==========|
#$ |===========================================|

#@ A partir de uma coluna existente
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
vendas_df['Comissão'] = vendas_df['Valor Final'] * 0.05
display(vendas_df)


#@ Criar coluna com valor padrao
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
vendas_df.loc[:,'Imposto'] = 0
display(vendas_df)



#$ |==========================================|
#$ |==========| Criando nova linha |==========|
#$ |==========================================|

#@ Adicionando outra tabela a tabela inicial
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
vendas_dez_df = pd.read_excel('vendas-dez.xlsx')
vendas_df = vendas_df.append(vendas_dez_df) 
display(vendas_df)



#$ |================================================|
#$ |==========| Excluir linhas e colunas |==========|
#$ |================================================|

#@ Axis = 0 -| linha / Axis = 1 -| coluna
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
vendas_df = vendas_df.drop(0, axis=0) 
display(vendas_df)



#$ |======================================|
#$ |==========| Valores vazios |==========|
#$ |======================================|

#@ Deletando linhas e colunas completamente vazias
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
vendas_dez_df = pd.read_excel('vendas-dez.xlsx')
vendas_df = vendas_df.append(vendas_dez_df) 
vendas_df = vendas_df.dropna(how='all', axis='0') 
display(vendas_df)


#@ Deletando linhas que possuem pelo menos 1 valor vazio
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
vendas_dez_df = pd.read_excel('vendas-dez.xlsx')
vendas_df = vendas_df.append(vendas_dez_df) 
vendas_df = vendas_df.dropna(axis='0') 
display(vendas_df)


#@ Preenchendo todos os valores vazios com a media de uma coluna
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
vendas_dez_df = pd.read_excel('vendas-dez.xlsx')
vendas_df = vendas_df.append(vendas_dez_df) 
vendas_df['Comissão'] = vendas_df['Comissão'].fillna(vendas_df['Comissão'].mean()) 
display(vendas_df)


#@ Preenchedo todos os valores vazios com o primeiro valor acima dele
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
vendas_dez_df = pd.read_excel('vendas-dez.xlsx')
vendas_df = vendas_df.append(vendas_dez_df) 
vendas_df = vendas_df.ffill() 
display(vendas_df)



#$ |============================================|
#$ |==========| Calcular indicadores |==========|
#$ |============================================|

#@ Contando quantas vezes cada loja apareceu no dataframe
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
transacoes_loja = vendas_df['ID Loja'].value_counts() 
display(transacoes_loja)


#@ Agrupando os produtos e obtendo a soma dos mesmos
import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
faturamento_produto = vendas_df[['Produto', 'Valor Final']].groupby('Produto').sum() 
display(faturamento_produto)



#$ |============================================|
#$ |==========| Mesclar 2 dataframes |==========|
#$ |============================================|

import pandas as pd
vendas_df = pd.read_excel('vendas.xlsx')
gerentes_df = pd.read_excel('gerentes.xlsx')
vendas_df = vendas_df.merge(gerentes_df)
display(vendas_df)