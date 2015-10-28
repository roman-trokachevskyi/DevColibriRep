package com.rodico.duke0808.teststeststests.TestPackege.Test;

import java.util.ArrayList;

/**
 * Created by duke0808 on 20.10.15.
 */
public class TestSet {
    static ArrayList<Test> tests;


    static public ArrayList<Test> getTests(){
        tests=new ArrayList<>();
        //add tests here

        //.................Example adding:
        //.....creating array of question:
        ArrayList<TestQuestion> questions = new ArrayList<>();
        //for each question we'll need array of answers
        String[] answers0;
        answers0 = new String[]{ "Roman", "Dima","Anatoliy","Bogdan" };
        //..constructor: questionText , numberOfQuestion , arrayOfAnswers , nOfRightAnswer
        questions.add(new TestQuestion("What is your name",4,answers0,0));

        String[] answers1;
        answers1 = new String[]{ "18", "23","45","60" };
        questions.add(new TestQuestion("What is your Age",4,answers1,1));

        String[] answers2;
        answers2 = new String[]{ "Homenka", "Rudneva","Smilanska","Gromova" };
        questions.add(new TestQuestion("Your Street please!&",4,answers2,1));

        //......Creating our test: Name  ,  Info abot it , arrayOfQuestion
        // ............WE NEED TO OVERRIDE  getResult()   !!!!!!!!!!
        Test testTest= new Test("Testing tests)))", "This si just about cheking my fragment and app",
                questions){
            @Override
            public String getResult() {
                switch (getCounterOfRight()){
                    case 0: return "Looser";
                    case 1: return "Not bad";
                    case 2: return "Good";
                    case 3: return "You're the best";
                }
                return super.getResult();
            }
        };
        //...adding our test to static array
        //tests.add(testTest);

        //... ADD NEXT TEST HERE:
        tests.add(getTestCommunicationStyle());
        tests.add(getTestTimeUsing());
        tests.add(getTestOverWeight());
        tests.add(getTestSelfConfident());
        tests.add(getEfficientTest());

        return tests;
    }

    public static Test getTestCommunicationStyle(){
        ArrayList<TestQuestion> questions = new ArrayList<>();

        String[] answers1;
        answers1 = new String[]{ "Всегда.", "Иногда.","Никогда."};
        questions.add(new TestQuestion("I . Склонны ли вы искать пути примирения после очередного служебного конфликта?"
                ,3,answers1,1));

        String[] answers2;
        answers2 = new String[]{ "Внутренне «кипите».", "Сохраняете полное спокойствие.","Теряете самообладание."};
        questions.add(new TestQuestion("II . Как вы ведете себя в критической ситуации?"
                ,3,answers2,1));
        String[] answers3;
        answers3 = new String[]{ "Самоуверенным и завистливым.", "Дружелюбным.","Спокойным и независимым."};
        questions.add(new TestQuestion("III. Каким(ой) считают вас коллеги?"
                ,3,answers3,1));
        String[] answers4;
        answers4 = new String[]{ "Примете ее с некоторыми опасениями.", "Согласитесь без колебаний.","Откажетесь от нее ради собственного спокойствия."};
        questions.add(new TestQuestion("IV. Как вы отреагируете, если вам предложат ответственную должность?"
                ,3,answers4,1));
        String[] answers5;
        answers5 = new String[]{ "Выдадите ему «по первое число».", "Заставите вернуть.","Спросите, не нужно ли ему еще что-нибудь."};
        questions.add(new TestQuestion("V. Как вы будете себя вести, если кто-то из коллег без разрешения возьмет с вашего стола бумагу?"
                ,3,answers5,1));
        String[] answers6;
        answers6 = new String[]{ "Что тебя так задержало?", "Где ты торчишь допоздна?","Я уже начал(а) волноваться."};
        questions.add(new TestQuestion("VI. Какими словами вы встретите мужа (жену), если он (она) вернулся (вернулась) с работы позже обычного?"
                ,3,answers6,1));
        String[] answers7;
        answers7 = new String[]{ "Стараетесь обогнать машину, которая «показала вам хвост».", "Вам все равно, сколько автомобилей вас обогнало.","Помчитесь с такой скоростью, чтобы никто не догнал вас."};
        questions.add(new TestQuestion("VII. Как вы ведете себя за рулем автомобиля?"
                ,3,answers7,1));
        String[] answers8;
        answers8 = new String[]{ "Сбалансированными.", "Легкомысленными.","Крайне «жесткими»."};
        questions.add(new TestQuestion("VIII. Какими вы считаете свои взгляды на жизнь?"
                ,3,answers8,1));
        String[] answers9;
        answers9 = new String[]{ "Пытаетесь свалить вину на другого.", "Смиряетесь.","Становитесь впредь осторожнее."};
        questions.add(new TestQuestion("IX. Что вы предпринимаете, если не все удается?"
                ,3,answers9,1));
        String[] answers10;
        answers10 = new String[]{ "Пора бы уже запретить молодежи такие развлечения."
                , "Надо создать ей возможность организованно и культурно отдыхать.","И чего мы с ней возимся?"};
        questions.add(new TestQuestion("X. Как вы реагируете на фельетон о случаях распущенности в среде современной молодежи?"
                ,3,answers10,1));
        String[] answers11;
        answers11 = new String[]{ "И зачем только я на это нервы тратил(а)?"
                , "Видно, этот человек начальнику приятнее.","Может быть, мне это удастся в другой раз."};
        questions.add(new TestQuestion("XI. Что вы ощущаете, если должность, которую вы хотели занять, досталась другому?"
                ,3,answers11,1));
        String[] answers12;
        answers12 = new String[]{ "Чувство страха."
                , "Скучаете.","Получаете искреннее удовольствие."};
        questions.add(new TestQuestion("XII. Какие чувства вы испытываете, когда смотрите страшный фильм?"
                ,3,answers12,1));
        String[] answers13;
        answers13 = new String[]{ "Будете нервничать во время заседания."
                , "Попытаетесь вызвать снисходительность партнеров.","Огорчитесь."};
        questions.add(new TestQuestion("XIII. Как вы будете себя вести, если образовалась «дорожная пробка» и вы опоздали на важное совещание?"
                ,3,answers13,1));
        String[] answers14;
        answers14 = new String[]{ "Обязательно стараетесь выиграть."
                , "Цените удовольствие почувствовать себя вновь молодым.","Очень сердитесь, если проигрываете,"};
        questions.add(new TestQuestion("XIV. Как вы относитесь к своим спортивным успехам?"
                ,3,answers14,1));
        String[] answers15;
        answers15 = new String[]{ "Стерпите, избегая скандала."
                , "Вызовете метрдотеля и сделаете ему замечание.","Отправитесь с жалобой к директору ресторана."};
        questions.add(new TestQuestion("XV. Как вы поступите, если вас плохо обслужили в ресторане?"
                ,3,answers15,1));
        String[] answers16;
        answers16 = new String[]{ "Поговорите с учителем."
                , "Устроите скандал родителям.","Посоветуете ребенку дать сдачи."};
        questions.add(new TestQuestion("XVI. Как вы поступите, если вашего ребенка обидели в школе?"
                ,3,answers16,1));
        String[] answers17;
        answers17 = new String[]{ "Средний."
                , "Самоуверенный.","Пробивной."};
        questions.add(new TestQuestion("XVII. Какой вы человек?"
                ,3,answers17,1));
        String[] answers18;
        answers18 = new String[]{ "Простите, это моя вина."
                , "Ничего, пустяки.","А повнимательнее вы не можете быть?"};
        questions.add(new TestQuestion("XVIII. Что вы скажете подчиненному, с которым столкнулись в дверях?"
                ,3,answers18,1));
        String[] answers19;
        answers19 = new String[]{ "Когда же, наконец, будут приняты конкретные меры?"
                , "Надо бы ввести суровые наказания!","Нельзя же все валить на молодежь, виноваты и воспитатели!"};
        questions.add(new TestQuestion("XIX. Ваша реакция на статью в газете о хулиганстве в среде молодежи?"
                ,3,answers19,1));
        String[] answers20;
        answers20 = new String[]{ "Тигра."
                , "Домашнюю кошку.","Медведя."};
        questions.add(new TestQuestion("XX. Какое животное вы любите?"
                ,3,answers20,1));

        final Test test= new Test("Тест \"Ваш стиль общения\"", "У каждого человека существует излюбленная манера общения — то, что обычно называют стилем общения. Ваш стиль общения поможет определить данный тест. На каждый из 20 вопросов даны три варианта ответов: отметьте тот, который вас устраивает.",
                questions){
            @Override
            public String getResult() {
                int count = 0;

                switch (this.getQuestionById(0).answeredId){
                    case 0: count+=1; break;
                    case 1: count+=2; break;
                    case 2: count+=3; break;
                }
                switch (this.getQuestionById(1).answeredId){
                    case 0: count+=2; break;
                    case 1: count+=1; break;
                    case 2: count+=3; break;
                }
                switch (this.getQuestionById(2).answeredId){
                    case 0: count+=3; break;
                    case 1: count+=2; break;
                    case 2: count+=1; break;
                }
                switch (this.getQuestionById(3).answeredId){
                    case 0: count+=2; break;
                    case 1: count+=3; break;
                    case 2: count+=1; break;
                }
                switch (this.getQuestionById(4).answeredId){
                    case 0: count+=3; break;
                    case 1: count+=2; break;
                    case 2: count+=1; break;
                }
                switch (this.getQuestionById(5).answeredId){
                    case 0: count+=1; break;
                    case 1: count+=2; break;
                    case 2: count+=3; break;
                }
                switch (this.getQuestionById(6).answeredId){
                    case 0: count+=2; break;
                    case 1: count+=1; break;
                    case 2: count+=3; break;
                }
                switch (this.getQuestionById(7).answeredId){
                    case 0: count+=2; break;
                    case 1: count+=1; break;
                    case 2: count+=3; break;
                }
                switch (this.getQuestionById(8).answeredId){
                    case 0: count+=3; break;
                    case 1: count+=2; break;
                    case 2: count+=1; break;
                }
                switch (this.getQuestionById(9).answeredId){
                    case 0: count+=3; break;
                    case 1: count+=1; break;
                    case 2: count+=2; break;
                }
                switch (this.getQuestionById(10).answeredId){
                    case 0: count+=1; break;
                    case 1: count+=2; break;
                    case 2: count+=3; break;
                }
                switch (this.getQuestionById(11).answeredId){
                    case 0: count+=3; break;
                    case 1: count+=2; break;
                    case 2: count+=1; break;
                }
                switch (this.getQuestionById(12).answeredId){
                    case 0: count+=1; break;
                    case 1: count+=3; break;
                    case 2: count+=2; break;
                }
                switch (this.getQuestionById(13).answeredId){
                    case 0: count+=2; break;
                    case 1: count+=3; break;
                    case 2: count+=1; break;
                }
                switch (this.getQuestionById(14).answeredId){
                    case 0: count+=1; break;
                    case 1: count+=3; break;
                    case 2: count+=2; break;
                }
                switch (this.getQuestionById(15).answeredId){
                    case 0: count+=1; break;
                    case 1: count+=2; break;
                    case 2: count+=3; break;
                }
                switch (this.getQuestionById(16).answeredId){
                    case 0: count+=1; break;
                    case 1: count+=3; break;
                    case 2: count+=2; break;
                }
                switch (this.getQuestionById(17).answeredId){
                    case 0: count+=1; break;
                    case 1: count+=3; break;
                    case 2: count+=2; break;
                }
                switch (this.getQuestionById(18).answeredId){
                    case 0: count+=2; break;
                    case 1: count+=1; break;
                    case 2: count+=3; break;
                }
                switch (this.getQuestionById(19).answeredId){
                    case 0: count+=3; break;
                    case 1: count+=2; break;
                    case 2: count+=1; break;
                }

                if (count>=35&&count<=44){
                    return "Вы умеренно агрессивны, вам сопутствует успех в жизни, поскольку у вас достаточно здорового честолюбия. К критике относитесь доброжелательно, если она деловая и без претензий.";
                }
                if (count<=34){
                    return "Вы чрезмерно миролюбивы, что обусловлено недостаточной уверенностью в собственных силах и возможностях. Это, конечно, не значит, что вы греетесь под любым ветерком. И все же побольше решительности вам не помешает! К критике «снизу» относитесь доброжелательно, но побаиваетесь критики «сверху». ";
                }
                if (count>=45){
                    return "Вы излишне агрессивны и неуравновешенны, нередко бываете чрезмерно жестким по отношению к другим людям. Надеетесь дойти до управленческих «верхов», рассчитывая на свои силы. Добиваясь успеха в какой-либо области, можете пожертвовать интересами окружающих. К критике относитесь двойственно: критику «сверху» принимаете, а критику «снизу» воспринимаете болезненно, порой небрежно. Можете преследовать критиков «снизу».";
                }

                return super.getResult();
            }
        };
        return test;

    }

    public static Test getTestTimeUsing(){
        ArrayList<TestQuestion> questions = new ArrayList<>();

        String[] answers1;
        answers1 = new String[]{ "почти никогда", "иногда","часто","почти всегда" };
        questions.add(new TestQuestion("Я резервирую в начале рабочего дня время для подготовительной работы, планирования."
                ,4,answers1,1));
        String[] answers2;
        answers2 = new String[]{ "почти никогда", "иногда","часто","почти всегда" };
        questions.add(new TestQuestion("Я перепоручаю все, что может быть перепоручено"
                ,4,answers2,1));
        String[] answers3;
        answers3 = new String[]{ "почти никогда", "иногда","часто","почти всегда" };
        questions.add(new TestQuestion("Я письменно фиксирую задачи и цели, с указанием сроков их реализации"
                ,4,answers3,1));
        String[] answers4;
        answers4 = new String[]{ "почти никогда", "иногда","часто","почти всегда" };
        questions.add(new TestQuestion("Каждый официальный документ я стараюсь обрабатывать за один раз и окончательно"
                ,4,answers4,1));
        String[] answers5;
        answers5 = new String[]{ "почти никогда", "иногда","часто","почти всегда" };
        questions.add(new TestQuestion("Каждый день я составляю список предстоящих дел, упорядоченный по приоритетам. Важнейшие вещи я делаю в первую очередь"
                ,4,answers5,1));
        String[] answers6;
        answers6 = new String[]{ "почти никогда", "иногда","часто","почти всегда" };
        questions.add(new TestQuestion("Свой рабочий день я освобождаю от посторонних телефонных разговоров незапланированных встреч, неожиданных совещаний"
                ,4,answers6,1));
        String[] answers7;
        answers7 = new String[]{ "почти никогда", "иногда","часто","почти всегда" };
        questions.add(new TestQuestion("Свою дневную нагрузку я распределяю в соответствии с графиком моей работоспособности"
                ,4,answers7,1));
        String[] answers8;
        answers8 = new String[]{ "почти никогда", "иногда","часто","почти всегда" };
        questions.add(new TestQuestion("В моем плане всегда есть окна, позволяющие реагировать на актуальные проблемы"
                ,4,answers8,1));
        String[] answers9;
        answers9 = new String[]{ "почти никогда", "иногда","часто","почти всегда" };
        questions.add(new TestQuestion("Я направляю свою активность таким образом, чтобы в первую очередь концентрироваться на немногих, «жизненно важных» проблемах"
                ,4,answers9,1));
        String[] answers10;
        answers10 = new String[]{ "почти никогда", "иногда","часто","почти всегда" };
        questions.add(new TestQuestion("Я умею говорить «нет», когда на мое время претендуют другие, а мне необходимо делать более важные дела"
                ,4,answers10,1));

        Test test = new Test("Методика \"Умение рационально использовать время\"", "Склонны ли вы планировать свое время и не находиться во власти внешних обстоятельств.", questions){
            @Override
            public String getResult() {

                int count=0;
                for (TestQuestion question : this.getQuestionArrayList()){
                    count+=question.answeredId;
                }

                if (count>=0&&count<=15){
                    return "Вы не планируете свое время и находитесь во власти внешних обстоятельств. Вы добьетесь своих целей, если составите список приоритетов и будете придерживаться его.";
                }
                if (count>=16&&count<=20){
                    return "Вы пытаетесь овладеть своим временем, но не всегда достаточно последовательны, чтобы иметь успех.";
                }
                if (count>=21&&count<=25){
                    return "У Вас достаточно высокий уровень самоменеджмента.";
                }
                if (count>=26&&count<=30){
                    return "Вы можете служить образцом каждому, кто хочет научиться рационально использовать свое время. У Вас стоит поучиться.";
                }

                return "";
            }
        };
        return test;
    }
    public static Test getTestOverWeight(){

        ArrayList<TestQuestion> questions = new ArrayList<>();

        String[] answers1;
        answers1 = new String[]{ "Нет", "Да", "Не знаю"};
        questions.add(new TestQuestion("1. Коллега в очередной раз зазывает вас испить чай с тортом. Вы в силах отказаться от угощения?"
                ,3,answers1,1));
        String[] answers2;
        answers2 = new String[]{ "Нет", "Да", "Иногда"};
        questions.add(new TestQuestion("2. Коробка конфет может проваляться у вас в шкафу несколько месяцев?"
                ,3,answers2,1));
        String[] answers3;
        answers3 = new String[]{ "Нет", "Да", "Иногда"};
        questions.add(new TestQuestion("3. В разгар производственного совещания вас посещают мысли о любимых блюдах?"
                ,3,answers3,1));
        String[] answers4;
        answers4 = new String[]{ "Нет", "Да", "Может быть"};
        questions.add(new TestQuestion("4. Ради красивой фигуры вы готовы каждый день проходить часть дороги на работу пешком?"
                ,3,answers4,1));
        String[] answers5;
        answers5 = new String[]{ "Нет", "Да", "Иногда"};
        questions.add(new TestQuestion("5. Вы регулярно читаете на этикетках продуктов их состав?"
                ,3,answers5,1));

        Test test = new Test("Тест: Cклонны ли вы к лишнему весу?", "Стоит ли Вам боятся лишнего веса? Может пора изменить образ жизни!? Узнайте, пройдя этот короткий тест."
                , questions){
            @Override
            public String getResult() {
                int count=0;
                switch (this.getQuestionById(0).answeredId){
                    case 0 : count+=2; break;
                    case 1 : count+=1; break;
                    case 2 : count+=0; break;
                }
                switch (this.getQuestionById(1).answeredId){
                    case 0 : count+=2; break;
                    case 1 : count+=1; break;
                    case 2 : count+=0; break;
                }
                switch (this.getQuestionById(2).answeredId){
                    case 0 : count+=1; break;
                    case 1 : count+=2; break;
                    case 2 : count+=0; break;
                }
                switch (this.getQuestionById(3).answeredId){
                    case 0 : count+=2; break;
                    case 1 : count+=1; break;
                    case 2 : count+=0; break;
                }
                switch (this.getQuestionById(4).answeredId){
                    case 0 : count+=1; break;
                    case 1 : count+=2; break;
                    case 2 : count+=0; break;
                }
                if (count<5){
                    return "Вы застенчивый, не очень уверенный в себе человек. Вам трудно преодолеть влияние коллектива и принятые в семье правила питания. Если вокруг вас все едят много, предпочитают калорийную пищу, вы тоже поправитесь. Подумайте, возможно, стоит дополнить круг общения активными подругами, которые будут звать вас на прогулки или в бассейн?";
                }
                if (count>=5&&count<=7){
                    return "Вы знаете, как следить за собой, и успешно это делаете. Однако и у вас случаются периоды расслабления, когда вы набираете вес. Самый опасный период для этого – осень и зима, так что будьте внимательны!";
                }
                if (count>=8){
                    return "Или у вас шикарная фигура от природы, или вас не волнует ваш внешний вид. Однако беспорядочное питание и сидячий образ жизни могут повредить не только фигуре, но и здоровью. Подумайте о том, что будет через 10–15 лет, и попробуйте стать чуть ближе к здоровому образу жизни!";
                }
                return "Eror";
            }
        };
        return test;
    }
    public static Test getTestSelfConfident(){
        ArrayList<TestQuestion> questions = new ArrayList<>();

        String[] answers1;
        answers1 = new String[]{ "короткое, но крепкое;", "продолжительное и интенсивное;", "легкое прикосновение."};
        questions.add(new TestQuestion("1. Какое вы предпочитаете рукопожатие?"
                ,3,answers1,1));
        String[] answers2;
        answers2 = new String[]{ "Лев, Овен, Козерог, Телец;", "Близнецы, Скорпион, Водолей, Стрелец;", "Рыбы, Рак, Дева, Весы."};
        questions.add(new TestQuestion("2. Ваш знак зодиака?"
                ,3,answers2,1));
        String[] answers3;
        answers3 = new String[]{ "нормальная, не требующая специального ухода;", "нечувствительная;", "сухая и чувствительная."};
        questions.add(new TestQuestion("3. Какая у вас кожа?"
                ,3,answers3,1));
        String[] answers4;
        answers4 = new String[]{ "она охотно пребывает в одиночестве;", "она хочет, чтобы ее пожалели;", "у нее какие-то проблемы."};
        questions.add(new TestQuestion("4. В парке на лавочке сидит женщина, погруженная в свои мысли. Вам кажется, что…"
                ,3,answers4,1));
        String[] answers5;
        answers5 = new String[]{ "быстро забывать неприятности и огорчения;", "думать не только о себе;", "если кого-то обманываю, испытываю муки совести."};
        questions.add(new TestQuestion("5. Что для вас характерно?"
                ,3,answers5,1));
        String[] answers6;
        answers6 = new String[]{ "треугольник;", "ромб;", "круг."};
        questions.add(new TestQuestion("6. Какая фигура вам больше нравится?"
                ,3,answers6,1));
        String[] answers7;
        answers7 = new String[]{ "парашютный спорт;", "прыжки в воду;", "альпинизм."};
        questions.add(new TestQuestion("7. Каким видом спорта вы занимались бы охотнее всего?"
                ,3,answers7,1));

        Test test = new Test("Тест: Уверены ли вы в себе?", "Этот тест поможет вам ответить на вопрос – уверенный ли вы в себе человек или только производите такое впечатление? Выберите один из предложенных вариантов ответа."
                , questions){
            @Override
            public String getResult() {
                int countA=0;
                int countB=0;
                int countC=0;
                switch (this.getQuestionById(0).answeredId){
                    case 0 : countA+=1; break;
                    case 1 : countB+=1; break;
                    case 2 : countC+=1; break;
                }
                switch (this.getQuestionById(1).answeredId){
                    case 0 : countA+=1; break;
                    case 1 : countB+=1; break;
                    case 2 : countC+=1; break;
                }
                switch (this.getQuestionById(2).answeredId){
                    case 0 : countA+=1; break;
                    case 1 : countB+=1; break;
                    case 2 : countC+=1; break;
                }
                switch (this.getQuestionById(3).answeredId){
                    case 0 : countA+=1; break;
                    case 1 : countB+=1; break;
                    case 2 : countC+=1; break;
                }
                switch (this.getQuestionById(4).answeredId){
                    case 0 : countA+=1; break;
                    case 1 : countB+=1; break;
                    case 2 : countC+=1; break;
                }
                switch (this.getQuestionById(5).answeredId){
                    case 0 : countA+=1; break;
                    case 1 : countB+=1; break;
                    case 2 : countC+=1; break;
                }
                switch (this.getQuestionById(6).answeredId){
                    case 0 : countA+=1; break;
                    case 1 : countB+=1; break;
                    case 2 : countC+=1; break;
                }

                if (countA>countB&&countA>countC){
                    return "Вы достаточно уверены в себе, но вам, естественно, не чужды ситуации, в которых вы чувствуете себя неуверенно. Однако вы можете в этом признаться, потому что вы сильная личность. Вам не нужно прикладывать больших усилий, обычно вы и так добиваетесь, чего хотите.";
                }
                if (countB>countA&&countB>countC){
                    return "Ваша уверенность в себе несколько неустойчива. Если вас поддерживает многолетний опыт, можете считать, что все в порядке. Но незнакомые люди, новые задачи раздражают вас больше, чем это объективно необходимо. В таких случаях вы легко теряете уверенность в своих силах. Тогда в зависимости от настроения вы либо замыкаетесь в себе, либо бываете излишне самоуверенны.";
                }
                if (countC>countA&&countC>countB){
                    return "Вам явно не хватает положительной самооценки. Вероятно, вы не привыкли доверять окружающим. Вы мучаете себя упреками и воспоминаниями, лишая себя при этом радости жизни. Постарайтесь найти время, чтобы проанализировать причину неуверенности в себе. Если у вас не получится, обратитесь за помощью к психологу.";
                }
                return "Eror";
            }
        };
        return test;
    }
    public static Test getEfficientTest(){
        ArrayList<TestQuestion> questions = new ArrayList<>();

        String[] answers1;
        answers1 = new String[]{ "Меньше 15", "Больше 15"};
        questions.add(new TestQuestion("1. Сколько дел вы делаете в течении дня?"
                ,2,answers1,1));
        String[] answers2;
        answers2 = new String[]{ "Меньше 6", "Больше 6"};
        questions.add(new TestQuestion("2. Сколько книг вы читаете в месяц?"
                ,2,answers2,1));
        String[] answers3;
        answers3 = new String[]{ "Да", "Нет"};
        questions.add(new TestQuestion("3. Вы уверенно можете сказать, что редко успеваете делать всё, что планируете на день"
                ,2,answers3,1));
        String[] answers4;
        answers4 = new String[]{ "Да", "Нет"};
        questions.add(new TestQuestion("4. У вас часто не хватает мотивации на то, чтоб что-то делать"
                ,2,answers4,1));
        String[] answers5;
        answers5 = new String[]{ "Да", "Нет"};
        questions.add(new TestQuestion("5. Вам часто приходится что-то делать через «Не хочу»"
                ,2,answers5,1));
        String[] answers6;
        answers6 = new String[]{ "Да", "Нет"};
        questions.add(new TestQuestion("6. Вы мечтаете о 25-м часе в сутках или даже о 26-м"
                ,2,answers6,1));
        String[] answers7;
        answers7 = new String[]{ "Да", "Нет"};
        questions.add(new TestQuestion("7. Вы честно можете признаться, что не довольны своей результативностью и понимаете, что можете больше"
                ,2,answers7,1));

        Test test = new Test("Тест «Оценка вашей личной эффективности»","Насколько Вы эффективны? К какой категории вы принадлежите? Узнайте свои показатели, пройдя этот короткий тест...", questions){
            @Override
            public String getResult() {
                int count=0;
                for (TestQuestion question : this.getQuestionArrayList()){
                    if (question.answeredId==0){
                        count++;
                    }
                }
                if (count>=6){
                    return "«Загнанная лошадь». Караул! Срочно необходимо что-то менять в своей жизни. Дальше будет только хуже. Возможно вас уже регулярно посещают депрессивные настроения, а также вы ощущаете хроническую усталость. Это еще не катастрофа и не конец. Выход есть! Главное признайтесь себе честно, что проблема существует и ее необходимо решать.";
                }
                if (count>=4&&count<=5){
                    return "«Рабочий». В принципе нормально. Не так плохо как у «Загнанной лошади», но и не супер. Может быть намного лучше. На самом деле вы находитесь в маленьком шаге от более высокого уровня и до него совсем чуть-чуть.";
                }
                if (count>=2&&count<=3){
                    return "«Другой». О таких людях говорят «Он не от мира сего». Вечно что-то придумывает, реализовывает и главное добивается своих целей. Он – мотор! Таких людей мало и они на вес золота. Они ездят на машинах среднего класса, живут в хороших квартирах и обычно не испытывают проблем с деньгами. Для многих людей жить такой жизнью – это мечта.";
                }
                if (count>=0&&count<=1){
                    return "«Точка отсчета». Об этих людях говорят вообще шопотом. Они живут своей жизнью. Жизнью Победителей. Они путешествуют сколько хотят, ездят на лучших автомобилях и наслаждаются всеми благами этого мира. Обычно они владельцы компаний или Топ-менеджеры потому, что знают цену времени. Они пример для всех!";
                }
                return "EROR!!!";
            }
        };
        return test;
    }


}




