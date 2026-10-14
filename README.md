# Sharingan (NeoForge 1.21.1) - versão 1.2.3

Mod que adiciona somente o Sharingan do Naruto: 1, 2 e 3 tomoe, Mangekyou (Itachi, Sasuke, Obito, Shisui) e Mangekyou Eterno.

## Compilar no GitHub
1. Crie um repositório e envie o conteúdo desta pasta (incluindo `.github`).
2. Aba **Actions** > workflow **Build mod** (roda sozinho a cada push).
3. Baixe o `.jar` em **Artifacts > sharingan-mod** e coloque em `mods/` com NeoForge 21.1.x.

## Teclas (reconfiguráveis em Controles > Sharingan; o HUD e as mensagens mostram a tecla real)
| Padrão | Ação |
|---|---|
| J | Aba Sharingan (olho em uso, retirar, partir o olho, layout) |
| V | Ativar/desativar Sharingan (som de vidro quebrando) |
| B | Ativar/desativar Mangekyou |
| \ , Z, X, C | Habilidades 1 a 4 (a 4 é o Susanoo) |

## Chakra
Sharingan só funciona com chakra (precisa de pelo menos 10% para ligar). O chakra **recupera 1 por segundo** com o Sharingan desligado (fixo, qualquer que seja o tamanho da barra). Apertar a tecla sem chakra não acelera nada: cada tentativa pausa a recuperação por 3 s.

A barra de 1, 2 e 3 tomoe é calculada como se todo Sharingan gastasse 1 por segundo (2 min = 120, 3 min e meio = 210, 5 min = 300), mas o gasto real continua o de cada olho:

| Modo ligado | Gasto por segundo | Barra (chakra máx.) | Duração real com a barra cheia |
|---|---|---|---|
| 1 tomoe | 2 | 120 | 1:00 |
| 2 tomoe | 1,5 | 210 | 2:20 |
| 3 tomoe | 1 | 300 | 5:00 |
| Mangekyou | 3 | igual ao 3 tomoe | 1:40 (300) a 5:20 (960) |
| Eterno | 3 | igual ao 3 tomoe | 1:40 (300) a 5:20 (960) |

O Mangekyou e o Eterno **só desbloqueiam**: não aumentam a barra (quem tem o Mangekyou mas usa só o Sharingan gasta 1 por segundo, como o 3 tomoe; ligando o Mangekyou passa a gastar 3).
Cada habilidade do Mangekyou gasta chakra (valor no HUD) e também desgasta o olho. O Susanoo custa 50 para ligar e gasta mais enquanto dura.

### Upgrades de chakra (aba "Chakra" da tela J)
**Pontos de habilidade:** com 3 tomoe ou mais, cada **400 de XP** ganho (usando o Sharingan, matando monstros, orbes) dá **1 ponto** (máximo 5 no total, ficam com o jogador e aparecem no HUD). Cada upgrade gasta **1 ponto + os níveis de XP** da tabela. O botão da aba Chakra agora é um quadrado ("C") no canto de cima do painel da tela J.

Do 3 tomoe em diante, a aba **Chakra** mostra uma árvore com o 3 tomoe no meio e 5 upgrades em sequência (para comprar o 5 precisa dos 4 anteriores). Cada upgrade custa **níveis de XP** e soma 132 de chakra máximo:

| Upgrade | Custo | Chakra máximo |
|---|---|---|
| 1 | 10 níveis | 432 |
| 2 | 15 níveis | 564 |
| 3 | 20 níveis | 696 |
| 4 | 25 níveis | 828 |
| 5 | 30 níveis | 960 |

Os upgrades ficam com o jogador (não vão no item do olho) e valem para o 3 tomoe, o Mangekyou e o Eterno. No modo criativo são de graça.

### Poção de Chakra
Na bancada de poções: **Poção Estranha + Fragmento de ametista = Poção de Chakra** (recupera 30% do chakra máximo na hora); **Poção de Chakra + Pó de glowstone = Poção de Chakra II** (60%). Também aceita pólvora (arremessável) e bafo de dragão (persistente), como as outras poções. Está na aba criativa do mod.

### Esquiva (desviar de ataques)
Com o Sharingan **ativo**, cada golpe que você levaria tem uma chance de ser desviado (o dano e o empurrão são cancelados, com fumaça, som e o aviso "Desviou!"):

| Olho ligado | Chance de esquiva |
|---|---|
| 1 tomoe | 20% |
| 2 tomoe | 30% |
| 3 tomoe | 40% |
| Mangekyou ou Eterno (Mangekyou ligado) | 50% |

- Só vale contra **ataques de entidades** (golpes de mobs e jogadores, flechas, tridentes, bolas de fogo...). Não vale contra queda, lava, fogo, afogamento, frio, explosões, vazio nem fome.
- **Cada esquiva bem-sucedida gasta 10 de chakra** (com menos de 10 de chakra não há esquiva).
- **Quando você desvia com sucesso**, a esquiva entra em recarga por **3 a 5 segundos** (sorteado, em tempo real). Durante a recarga ela não funciona. Levar um golpe (falhar no sorteio) **não** gera recarga: você pode tentar desviar de novo no golpe seguinte.
- **Projéteis de outros mods** (ex.: magias com projétil do Iron's Spells 'n Spellbooks) também podem ser desviados, mesmo com dano mágico. Magias instantâneas/de área, sem entidade de projétil, não podem.
- Ao desviar aparece um **afterimage** (uma silhueta vermelha ao lado do jogador, visível para quem está perto) que dura 1 segundo.
- Desligar o Mangekyou (ou ele desligar sozinho) encerra na hora o Susanoo, a intangibilidade e a sucção do Kamui.
- Depois de desviar, golpes seguintes por 0,7 s (ex.: slime encostado) também são evitados.
- O HUD mostra a chance e a recarga ("Esquiva 30%: pronta" / "Esquiva 30%: 7s"), e a aba J mostra a chance de cada estágio.
- A recarga conta mesmo se você desligar o Sharingan e continua enquanto o jogo estiver mais lento; morrer zera a recarga.

### Efeitos colaterais de chakra baixo (cumulativos, em % do chakra máximo atual)
Com 30%: fome. Com 22,5%: lentidão. Com 15%: náusea. Com 7,5%: fraqueza. Pioram até o Sharingan desligar por falta de chakra. (Ex.: 1 tomoe, barra de 120: começa em 36.)

### Sharingan ativo limpa efeitos ruins
Com o Sharingan ligado (qualquer tomoe) somem náusea, escuridão e cegueira. A náusea do chakra baixo (a partir de 15% do máximo) continua.

## Clã Uchiha e despertar
Todo jogador recebe o **Emblema do Clã Uchiha** ao entrar pela primeira vez no mundo (textura oficial). Clique direito para pertencer ao clã. **Só quem é do Clã Uchiha pode despertar o Sharingan** (30% de chance ao sobreviver a um golpe quase fatal) e **só uma vez por mundo**: quem já teve um Sharingan, mesmo retirado, só consegue outro por implante. Sem o clã: +50% de recarga e de custo de chakra, +25% de desgaste ocular.

## Progressão
- **Despertar**: sobreviver a um golpe que deixe você com 2 corações ou menos (Uchiha, uma vez).
- **1 > 2 tomoe**: 170 XP. **2 > 3 tomoe**: 350 XP. Com o Sharingan ativo: +10 por monstro morto, XP de orbes coletados e +1 por segundo.
- **Mangekyou**: com 3 tomoe, quando um pet domesticado SEU morre o Mangekyou vem aleatório (Itachi, Sasuke, Obito ou Shisui). Só o **dono** do animal recebe, e a morte pode ser de qualquer jeito e por qualquer motivo (outro jogador, mob, queda, fogo, vazio, afogamento, comando...), desde que o dono esteja online. Quem matou o pet de outro jogador não recebe nada.
- **Eterno**: com os dois olhos inteiros do Mangekyou de Itachi ou Sasuke, implante o olho do outro. O Eterno devolve a visão enquanto estiver nos seus olhos (a cegueira volta se você tirá-lo) e não acumula desgaste.

## Retirar, partir e implantar
- **Retirar o Sharingan**: o botão da aba J entrega o item na sua mão em qualquer estágio. 1/2/3 tomoe viram o item do estágio (guarda o XP). O Mangekyou e o Eterno saem junto com o 3 tomoe, num item só, e você fica sem Sharingan. Desgaste e cegueira continuam com você.
- **Partir o olho**: qualquer Sharingan (1/2/3 tomoe, Mangekyou, Eterno) pode ser partido. O olho que sai é sorteado, esquerdo ou direito, e vira um item na sua mão para dar a outro jogador. Você fica só com o outro olho: recargas +50%, desgaste -50%, **sem Susanoo** (o Susanoo exige os dois olhos), e só aquele olho aparece no seu rosto. Usar o item do olho que falta (mesmo Sharingan) une os dois de novo.
- **Implantar**: clique direito no item. O item **substitui** o Sharingan que você tiver (o antigo volta como item). Quem recebe fica com o mesmo XP que o dono tinha; sem o Clã Uchiha vêm as penalidades acima.

## Recarga de ligar/desligar
Depois de ligar ou desligar o Sharingan ou o Mangekyou há 2 segundos de espera para mexer de novo (evita ligar e desligar sem parar). Desligar o Mangekyou desliga também o Sharingan de 3 tomoe.

## Sons
Ligar o Sharingan (1/2/3 tomoe): "Ativando Sharingan". Desligar qualquer um (inclusive o Mangekyou ou ficar sem chakra): "Sharingan desliga". Mangekyou: Sasuke tem o próprio áudio; Itachi e Obito com os dois olhos usam o mesmo; Obito com um olho tem áudio do olho esquerdo e do direito; o Eterno toca o áudio de estreia na primeira vez e depois usa o do Sasuke; o Shisui usa o som do Sharingan normal. Os arquivos estão em `assets/sharingan/sounds` (convertidos para mono, com volume ajustado).

## Conquistas
Aba de conquistas "Sharingan": Sangue Uchiha (usar o emblema), Olhos Despertos, Segundo Tomoe, Três Tomoe, A Dor da Perda (Mangekyou), Luz Eterna (Eterno), Todos os Mangekyou (ter tido os 4 tipos), Susanoo!, Metade dos Olhos (partir o olho) e O Preço do Poder (cegueira permanente). Também são concedidas por implante ou por comando.

## Idioma
Os textos saem em português para quem joga em Português (Brasil) ou Português (Portugal) e em inglês nos demais idiomas (`lang/en_us.json`, `pt_br.json`, `pt_pt.json`).

## Morte
Ao morrer, o Sharingan/Mangekyou/Susanoo são desligados e todas as habilidades e recargas são resetadas.

## Diminuir os ticks (tick rate do jogo)
Com o Sharingan ativo o jogo inteiro roda a (20 - N) ticks por segundo, igual ao `/tick rate`: 18 (1 tomoe), 17, 16, 15 (Mangekyou) e 14 (Eterno). Isso desacelera tudo, inclusive você, e vale para o servidor todo (com vários jogadores vale o maior N). Ao desligar volta a 20. O chakra é compensado, então a duração em tempo real não muda.

## Aba J e layout
A aba mostra o Sharingan em uso: com o Sharingan ligado aparece o de tomoe (e diz se o Mangekyou está desbloqueado); com o Mangekyou ligado aparece o Mangekyou; desligado, o olho fica escuro e marcado como (desativado).
O botão **Layout** abre o editor: arraste os olhos no rosto, mude o tamanho (controle ou roda do mouse sobre o rosto) e arraste os blocos do HUD (status/chakra e habilidades). Por padrão as habilidades ficam no canto inferior direito. Os blocos do HUD são 30% menores (escala 70%) para não sobrepor a vida, a fome e a hotbar. O layout é salvo em `config/sharingan-layout.properties`.

## Rosto
Os olhos aparecem no rosto do jogador (visível para todos em terceira pessoa) enquanto o Sharingan está ativo, com o desenho do estágio atual. Com um olho só, aparece só o esquerdo ou só o direito. No multiplayer, o tamanho e a posição dos olhos que cada jogador escolhe no editor valem só para o rosto dele: todos veem o rosto de cada um do jeito que o dono configurou (o servidor repassa a configuração; ela é reenviada ao entrar no mundo e ao salvar no editor).

## Habilidades
- **Itachi**: Tsukuyomi, Amaterasu, Karasu Bunshin (6 clones de corvo de verdade, 10 s: orbitam você e atacam inimigos próximos, causando dano e cegueira).
- **Sasuke**: Chidori Corrente, Enton: Kagutsuchi, Kirin.
- **Obito**: Kamui Intangibilidade (sem ficar invisível), Kamui Teletransporte, Kamui Sucção (o ponto de sucção fica bem longe de você, então um creeper puxado não explode em você).
- **Shisui**: Kotoamatsukami (o mob dominado vira seu **aliado para sempre**: não expira, não some por distância e continua aliado depois de reiniciar o mundo), Shunshin e Olhar Revelador (destaca as entidades ao redor por **45 segundos**; o contorno aparece **só para quem usou**, nenhum outro jogador vê).
- **Eterno**: Tsukuyomi, Amaterasu, Kirin e Susanoo Perfeito.
- **Susanoo** (tecla 4): só com os dois olhos.

## Cegueira (permanente)
O desgaste ocular nunca diminui. Em média cada habilidade soma cerca de 1% (uns 100 usos até cegar). Ao chegar a 100% você fica com o efeito de cegueira para sempre e a tela preta; com o Sharingan ativo o efeito some e você só vê silhuetas escuras. O Mangekyou Eterno devolve a visão enquanto estiver nos olhos.

## Comandos de teste (OP)
`/sharingan stage <0-3>`, `/sharingan mangekyou <itachi|sasuke|obito|shisui|eterno>`, `/sharingan xp <n>`, `/sharingan chakra`, `/sharingan uchiha <true|false>`, `/sharingan blind`, `/sharingan cure`, `/sharingan reset` (volta a poder despertar).

## Texturas
Os olhos e o emblema vêm das imagens em `tools/source` (convertidas por `tools/process_images.py`).

## Células de Hashirama
Implante **permanente**: clique direito com o item **Células de Hashirama**. O primeiro clique mostra um aviso; clique de novo em até 10 segundos para confirmar. **Depois de implantadas não dá para tirar**: só um administrador, com o comando `/sharingan hashirama remove [jogador]` (e `/sharingan hashirama give` para testes). Efeitos:
- **+5 corações** de vida.
- **Pressa I infinita**.
- **+2 de regeneração de chakra** por segundo (soma ao 1 de base: fica 3/s com o Sharingan desligado).
- **Regenera o desgaste ocular: 1% por minuto** (quem já ficou cego não recupera).
A situação aparece na aba J, no botão **H** ao lado do botão do Chakra.

### Como conseguir
1. **Amostra de Hashirama** (mesa de trabalho): Carne podre, Estrela do Nether, Bola de fogo em cima; Estrela do Nether, um tronco (qualquer) e Estrela do Nether no meio; Fragmento de ametista, Estrela do Nether e Lágrima de ghast embaixo.
2. **Laboratório de Análise** (mesa de trabalho): 8 tábuas (qualquer madeira) em volta, Luneta em cima no meio e Vidro (ou painel de vidro) no centro.
3. No laboratório: coloque a amostra e clique em **Iniciar análise**. Depois de **30 s** analisando ele **pede 5 itens**, um de cada vez (sorteados entre Carvão, Diamante, Redstone, Esmeralda, Fragmento de ametista, Pó de blaze, Fungo do Nether e Osso). Coloque o item pedido no slot do meio. Depois do quinto, uma **análise final de 30 s** entrega as **Células de Hashirama** no slot de resultado.

## Rosto: girada e espelhamento
- Ao ligar o Sharingan os olhos **dão uma girada** (cerca de 1 s) antes de ficar normais; todos os jogadores veem.
- No editor de layout (aba J > Layout) há a opção **Espelhar olhos**, que vira a textura dos olhos na horizontal (para personagens vesgos). Também é sincronizada com os outros jogadores.
