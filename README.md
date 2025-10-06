
# Avaliação Prática — Design Patterns (Java)

> **Aluno:** Yann Lucas

> **Disciplina:** Padrões de Projeto

> **Entrega:** 06/10/2025, 23h59

---

## Questão 1 — Cálculo de tarifas por modalidade (Terrestre, Aéreo, Marítimo)

### Enunciado

Uma empresa de logística precisa desenvolver um sistema de cálculo de tarifas para diferentes tipos de transporte: terrestre, aéreo e marítimo. Cada modalidade tem regras próprias para determinar o valor da entrega (p.ex., terrestre usa distância em km; aéreo usa peso). Implementar uma solução que trate todas as modalidades de forma genérica, respeitando regras específicas.

### Padrão aplicado: **Strategy**

**Por quê?** O algoritmo de cálculo varia por modalidade. Com **Strategy**, encapsulo cada regra em uma classe distinta que implementa uma mesma interface (`FreightStrategy`). Assim, o **contexto** (ex.: `Shipment`) delega o cálculo à estratégia selecionada em _runtime_, evitando condicionais extensos e permitindo adicionar novas modalidades sem alterar código existente (**Open/Closed**).

### Estrutura (resumo)

-`FreightStrategy` (interface): `BigDecimal calculate(Shipment s)`

- Estratégias concretas: `LandFreight`, `AirFreight`, `SeaFreight`

-`Shipment` (contexto/dados): distância, peso, volume, taxa base

-`StrategyDemo` (main): demonstra troca de estratégia

### Pontos de projeto

-**Vantagens:** extensão fácil (ferroviário amanhã), testes unitários por regra, baixo acoplamento.

-**Trade-offs:** uma classe por regra (aumenta número de tipos), mas melhora a coesão.

-**Erros comuns evitados:** cálculos com `if/else` gigantes; mistura de dados de frete com regra de negócio.

### Extensão

- Adicionar `RailFreight` sem tocar em `Shipment` ou nas outras estratégias.
- Compor estratégias (ex.: sobretaxa sazonal) via **Decorator** se necessário.

---

## Questão 2 — Processadores de pagamento (Cartão, Boleto, PIX)

### Enunciado

A plataforma deve integrar diferentes meios de pagamento. A escolha do meio é configurável e o sistema precisa **instanciar dinamicamente** o processador correspondente **sem** que o código principal conheça detalhes de criação.

### Padrão aplicado: **Factory Method** (Simple Factory)

**Por quê?** O cliente precisa de um **objeto** (`PaymentProcessor`) sem saber **como criá-lo**. A **fábrica** concentra a lógica de criação com base em um `enum`/config. Isso reduz acoplamento e facilita adicionar novos meios (ex.: **TED**, **Carteira**).

### Estrutura (resumo)

-`PaymentProcessor` (interface): `boolean process(BigDecimal amount)`

- Concretos: `CreditCardProcessor`, `BoletoProcessor`, `PixProcessor`

-`PaymentFactory` (creator): `create(PaymentType)` retorna o concreto

-`FactoryMethodDemo` (main)

```text

Client --calls--> PaymentFactory.create(type) --> returns PaymentProcessor

```

### Pontos de projeto

-**Vantagens:** criação centralizada, cliente depende só da interface.

-**Trade-offs:** a fábrica precisa ser atualizada quando um novo meio surge (mitigável via reflexão/registro).

-**Robustez:** valida `null` e cobre todos valores do `enum` (ou `default`).

### Extensão

- Adicionar antifraude (cadeia de responsabilidade) ou **Strategy** para taxas dinâmicas por meio.

---

## Questão 3 — Assinatura de tópicos e notificações

### Enunciado

Leitores se inscrevem em tópicos (política, esportes, tecnologia). Quando uma notícia é publicada em um tópico, todos inscritos recebem notificação automaticamente. Deve suportar múltiplos tópicos e leitores sem controle manual por parte do site.

### Padrão aplicado: **Observer (Publish/Subscribe)**

**Por quê?** Desacopla **quem emite** (tópico) de **quem consome** (leitor). Tópicos mantêm lista de assinantes e chamam `update(...)` quando há novidade. Fácil ter n tópicos e n leitores, com (des)inscrição dinâmica.

### Estrutura (resumo)

-`Subscriber` (Observer): `update(topic, title)`

-`Reader` (ConcreteObserver)

-`Topic` (Subject): `subscribe`, `unsubscribe`, `publish`

-`NewsHub` (registry/mapeia tópicos)

```text

Topic --publish(news)--> notifica todos Subcribers inscritos

```

### Pontos de projeto

-**Vantagens:** baixo acoplamento, escalável, testável.

-**Trade-offs:** ordem de notificação e falhas de um assinante devem ser tratadas (isolamento).

-**Robustez:** usar `Set` para evitar duplicidade; sincronização se fosse multi-thread.

### Extensão

- Filtros por palavra-chave, _throttling_ por usuário, filas assíncronas (Executor/Reactive).

---

## Questão 4 — Relatórios com recursos opcionais (Estatísticas, Gráficos, PDF)

### Enunciado

Sistema gera um relatório básico (lista de pedidos). Depois, gestor pode optar por **adicionar** estatísticas, gráficos ou exportação em PDF. Os recursos devem ser opcionais e **sem alterar** o relatório básico.

### Padrão aplicado: **Decorator**

**Por quê?** Permite **compor** funcionalidades em tempo de execução: cada _feature_ é um **decorador** que “embrulha” o relatório base (`Report`). Evita herança explosiva (ex.: `Report+Stats+Chart+Pdf`, `Report+Stats+Pdf`, etc.).

### Estrutura (resumo)

-`Report` (componente): `String generate()`

-`BasicSalesReport` (concreto base)

- Decorators: `RevenueStatsDecorator`, `ChartDecorator`, `PdfExportDecorator`

-`DecoratorDemo` (main)

```text

Report r = new PdfDecorator(new ChartDecorator(new StatsDecorator(new BasicReport(...))));

```

### Pontos de projeto

-**Vantagens:** combinação flexível de recursos; princípio aberto/fechado.

-**Trade-offs:** mais objetos e encadeamento; documentação clara ajuda.

-**Robustez:** decorators devem ser **transparentes** (não quebrar contrato).

### Extensão

- Exportadores alternativos (CSV, HTML), cache de seções caras, i18n.

---

## Questão 5 — Clonagem de modelos personalizáveis (Currículo, Proposta, Relatório)

### Enunciado

Há modelos de documentos com cores, fontes, logotipo e seções. É preciso gerar **cópias personalizáveis** rapidamente, sem reconstruir toda a estrutura do zero.

### Padrão aplicado: **Prototype**

**Por quê?** Permite **clonar** um objeto “modelo” (que pode ter estruturas internas complexas) de forma **rápida e independente**, garantindo **deep copy** para que personalizações de um cliente não afetem o protótipo nem outros clones.

### Estrutura (resumo)

-`DocumentPrototype` (contrato): `cloneDeep()`

-`Style` (agregado, `Cloneable`/cópia manual)

-`DocumentTemplate` (nome, `Style`, `List<String> sections`)

- Concretos: `ResumeTemplate`, `ProposalTemplate`, `ReportTemplate`

-`PrototypeRegistry` (mapa `key -> protótipo` para clonar por chave)

-`PrototypeDemo` (main)

```text

registry["resume"] --cloneDeep()--> nova instância isolada --> customize(...)

```

### Pontos de projeto

-**Vantagens:** desempenho (sem recriar tudo), isolamento entre cópias.

-**Trade-offs:** cuidado com **deep copy** (clonar listas/objetos internos).

-**Robustez:** testes garantem que mutações no clone não afetam o protótipo.

### Extensão

- Suporte a múltiplos `Style` (tema claro/escuro), blocos complexos (tabelas, gráficos), versionamento de modelos.

---