# 📘 Projeto Base Android — Documentação

Este projeto serve como **base e documentação** para futuros projetos Android, com foco em **boas práticas**, **arquitetura limpa** e **padronização**.

A ideia é que qualquer novo projeto possa partir daqui, evitando retrabalho e erros comuns de configuração.

---

## 🎯 Temas abordados neste projeto

* Flavors
* Hilt (Injeção de Dependência)
* Arquitetura MVVM
* Retrofit (incluindo Gson)
* Firebase *(configuração futura)*
* Modularização *(planejado para o futuro)*

---

## 🧱 Arquitetura adotada — MVVM + Clean Architecture

### 📐 Camadas do projeto

**Presentation**

* Camada de UI (Activity / Fragment)
* ViewModel
* LiveData / State
* Responsável apenas por exibir dados e reagir a eventos de UI

**Domain**

* Regras de negócio
* UseCases
* Models de domínio
* Interfaces de repositório
* **Não depende de Android**

**Data**

* Implementações dos repositórios
* Comunicação com APIs (Retrofit)
* DTOs e mapeamentos
* Fontes de dados (remote / local)

> 📌 A UI nunca acessa DTOs ou APIs diretamente. Toda comunicação passa pelo Domain.

---

## 🎨 Flavors

Flavors permitem gerar múltiplas versões do app a partir do mesmo código (ex: ambiente de teste e produção).

### 📚 Documentação oficial

* [https://developer.android.com/build/build-variants?hl=pt-br](https://developer.android.com/build/build-variants?hl=pt-br)

### 🎥 Vídeo de referência

* [https://www.youtube.com/watch?v=9UBuTR0IrEw](https://www.youtube.com/watch?v=9UBuTR0IrEw)

### 📂 Arquivos relacionados

* `build.gradle.kts (app)`
* `colors.xml`
* `strings.xml`
* `MainActivity.kt`

### 🧠 Uso comum

* Alterar `applicationId`
* URLs diferentes por ambiente
* Cores, nomes ou comportamentos distintos

---

## 💉 Hilt — Injeção de Dependência

O Hilt é usado para gerenciar dependências automaticamente, reduzindo acoplamento e facilitando testes.

### 📚 Documentação oficial

* [https://developer.android.com/training/dependency-injection/hilt-android?hl=pt-br](https://developer.android.com/training/dependency-injection/hilt-android?hl=pt-br)

### 🎥 Vídeo de referência

* [https://www.youtube.com/watch?v=u7LSb3ECTq0](https://www.youtube.com/watch?v=u7LSb3ECTq0)

### 🔗 Links importantes

* Versões do KSP compatíveis com Kotlin:
  [https://github.com/google/ksp/releases?page=8](https://github.com/google/ksp/releases?page=8)

* Guia oficial do Hilt com KSP:
  [https://dagger.dev/dev-guide/ksp.html](https://dagger.dev/dev-guide/ksp.html)

### 🛠️ Passos de configuração

1. Adicionar o plugin do Hilt
2. Adicionar dependências `hilt-android` e `hilt-compiler`
3. Criar classe `Application` anotada com `@HiltAndroidApp`
4. Criar módulos com `@Module` e `@InstallIn`
5. Usar `@Inject` nos construtores

### 📌 Observações importantes

* Todo `@Module` precisa de `@InstallIn`
* Retrofit e OkHttp devem usar `SingletonComponent`
* ViewModels usam `@HiltViewModel`

---

## 🌐 Retrofit (com Gson)

O Retrofit é utilizado para comunicação com APIs REST.

### 📚 Documentação oficial

* [https://square.github.io/retrofit/configuration/](https://square.github.io/retrofit/configuration/)

### 📦 O que é usado

* Retrofit
* OkHttp
* Converter Gson

### 🧠 Boas práticas

* Configurar Retrofit via Hilt
* Usar DTOs para resposta da API
* Converter DTO → Domain Model
* Nunca expor DTO para a UI

---

## 🧠 ViewModel + LiveData

### ViewModel

* Responsável por conter a lógica da UI
* Sobrevive a mudanças de configuração
* Comunica-se com o Domain (UseCases)

### LiveData

* Observável e lifecycle-aware
* Evita vazamentos de memória
* Atualiza a UI automaticamente

### Fluxo recomendado

UI → ViewModel → UseCase → Repository → API

Resposta:
API → Repository → UseCase → ViewModel → LiveData → UI

---

# Organização de Projeto Android Multimódulo

Este guia ensina como criar e utilizar módulos customizados dentro de uma pasta `modules` em projetos Android, uma estrutura moderna e recomendada para projetos escaláveis.

---

## Passo a Passo para Adicionar Módulos no Android

### **1. Crie o Projeto Base**

Crie normalmente seu projeto Android no Android Studio.

---

### **2. Crie a Pasta de Módulos**

Na raiz do projeto (mesmo nível do `app`), adicione uma pasta chamada `modules`:

```
seu_projeto/
├── app/
├── modules/
│
```

---

### **3. Crie um Novo Módulo**

No Android Studio:

- Vá em: `File > New > New Module`
- Selecione: **Android Library**
- Escolha um nome simples para o módulo (ex: `authentication`)
- Finalize a criação; o módulo será criado na raiz do projeto.

---

### **4. Mova o Novo Módulo para a Pasta `modules`**

No seu sistema operacional (Windows Explorer, Finder, etc):

- Feche o Android Studio (opcional, mas recomendado).
- Mova a pasta do novo módulo para `modules/`.

Exemplo:
```
seu_projeto/
├── app/
├── modules/
│   └── authentication/
```

---

o modulo common é usado como util

### **5. Configure o Gradle**

No arquivo de configuração de módulos (`settings.gradle` ou `settings.gradle.kts`) na raiz do seu projeto, adicione:

```groovy
include(":modules:authentication")
project(":modules:authentication").projectDir = file("modules/authentication")
```

Repita essas linhas para cada módulo criado, ajustando o nome e caminho.

---

### **6. Adicione o Módulo como Dependência**

No arquivo `build.gradle` do app:

```groovy
dependencies {
    implementation project(":modules:authentication")
    // Outros módulos:
    implementation project(":modules:test")
}
```

---

### **7. Sincronize o Projeto**

Clique em **File > Sync Project with Gradle Files** no Android Studio ou use o botão "Sync Now" no topo da IDE.

---

## Dicas

- Sempre use nomes simples para os módulos, sem espaços ou acentuação.
- Para criar novos módulos, repita a partir do Passo 3.
- Se necessário, verifique se os pacotes e Manifests dos módulos estão corretos.

---

Pronto! Agora você pode organizar seu projeto Android em múltiplos módulos de forma profissional, usando a pasta `modules` para facilitar a escalabilidade e colaboração.
## 🔥 Firebase (planejado)

Integração futura para:

* Analytics
* Crashlytics
* Push Notifications
* Remote Config

---

## 🧩 Modularização (futuro)

Planejamento para dividir o projeto em módulos:

* core
* domain
* data
* feature-* (login, user, home, etc)

Benefícios:

* Build mais rápido
* Melhor isolamento
* Reuso de código

---

## ✅ Conclusão

Este projeto foi criado para servir como **template profissional**, facilitando:

* Criação de novos apps
* Manutenção
* Escalabilidade
* Padronização entre projetos
* 

> Sempre que iniciar um novo projeto, a recomendação é duplicar este template e adaptar apenas regras de negócio e UI.
