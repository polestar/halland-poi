package com.example.varbergpoi.dummydata

import com.example.varbergpoi.R

class DummyHandler {
    companion object{
        private var inst:DummyHandler? = null
        fun getInstance() : DummyHandler{
            if(inst == null) {
                inst = DummyHandler().apply {
                    categories.add(Category().apply {
                        titleRes = R.string.category_food_drinks_title
                        subCategories.add(SubCategory().apply {
                            titleRes = R.string.subcategory_food_title
                            points.add(POIItem().apply {
                                title = "A little party"
                                description = "Visste du att Halmstad har något så unikt som en champagnebar? Precis vid Nissans kajkant hittar du denna pärla, perfekt för dig som älskar champagne med noga utvalda tillbehör och välsmakande varmrätter. I kylarna hos A Little Party finns alltid mer än tvåhundra olika champagner och samtliga går att få på glas."
                                coordinates = Pair(56.673635, 12.8594344)
                            })
                            points.add(POIItem().apply {
                                title = "Agave Glocal"
                                description = "Ny mexikansk restaurang i Haverdal. Med en förkärlek för chili, närproducerade råvaror och det mexikanska köket slår nu Agave Glocal upp portarna och bjuder på burritos, tacos al Pastor och mängder av guacamole såklart."
                                coordinates = Pair(56.730935, 12.6670906)
                            })
                            points.add(POIItem().apply {
                                title = "Asian Bank Office"
                                description = "Här kan du räkna med ett Asian fusion-koncept som ligger helt rätt i tiden. De tilltalande sharing-rätterna är en fröjd för såväl öga som gom. Här grundas filosofin i att arbeta med så bra lokalproducerade råvaror som möjligt i samklang med de bästa asiatiska smakerna. Ett tips är att testa den japanska traditionen omakase som låter kocken bestämma. Omakase betyder helt enkelt ”I will leave it to you!”. Missa inte heller deras spännande och välarbetade drinkmeny med typiska smaker av Asien och svensk skog."
                                coordinates = Pair(56.674391465644575, 12.858451008796692)
                            })
                            points.add(POIItem().apply {
                                title = "Bettans Bar"
                                description = "Med havet som närmsta granne njuter du här av skaldjur, sushi och asiatisk fusion som en spännande kulinarisk twist. Nytänkande smaksensationer möter konstfulla matupplevelser som inte lämnar någon besviken. Bettans Bar är en av Hotel Tylösands restauranger och bjuder in till bubbliga luncher och välsmakande middagar. Säsongsöppet från försommaren till sensommaren."
                                coordinates = Pair(56.6482979, 12.7291465)
                            })
                        })
                        subCategories.add(SubCategory().apply {
                            titleRes = R.string.subcategory_drinks_title
                            points.add(POIItem().apply {
                                title = "Strandhotellet"
                                description = "Varmt välkomna hem till Strandhotellet, där mat möter upplevelser som tillsammans blir ett. I den anrika byggnaden från 1927 kan du njuta av god mat & dryck i mysig miljö. Maten är inspirerad från alla världens kök, och passionen för mat och dryck speglas på din tallrik och drycken du har i glaset. De råvaror som serveras ifrån Strandhotellets meny är framtagna med största omsorg och ligger personalen varmast om hjärtat. Du kan också hyra bastun nere i sanddynerna med magisk utsikt över det böljande havet. Övriga aktiviteter finns det gott om för alla åldrar: shuffleboards, biljardbord, darttavlor, fotbollsspel och inte minst - en nybyggd äventyrsgolfbana."
                                coordinates = Pair(56.514379870926234, 12.948337197303774)
                            })
                            points.add(POIItem().apply {
                                title = "A little party"
                                description = "Visste du att Halmstad har något så unikt som en champagnebar? Precis vid Nissans kajkant hittar du denna pärla, perfekt för dig som älskar champagne med noga utvalda tillbehör och välsmakande varmrätter. I kylarna hos A Little Party finns alltid mer än tvåhundra olika champagner och samtliga går att få på glas."
                                coordinates = Pair(56.673635, 12.8594343)
                            })
                            points.add(POIItem().apply {
                                title = "Asian Bank Office"
                                description = "Här kan du räkna med ett Asian fusion-koncept som ligger helt rätt i tiden. De tilltalande sharing-rätterna är en fröjd för såväl öga som gom. Här grundas filosofin i att arbeta med så bra lokalproducerade råvaror som möjligt i samklang med de bästa asiatiska smakerna. Ett tips är att testa den japanska traditionen omakase som låter kocken bestämma. Omakase betyder helt enkelt ”I will leave it to you!”. Missa inte heller deras spännande och välarbetade drinkmeny med typiska smaker av Asien och svensk skog."
                                coordinates = Pair(56.674391465644575, 12.858451008796692)
                            })
                            points.add(POIItem().apply {
                                title = "Blue Skybar"
                                description = "På nionde våningen på Halmstad Plaza hittar du Blue Skybar, en läcker takbar där terrassen ger en magisk vy över Laholmsbukten. Här serveras ett brett utbud av cocktails liksom flera smarriga alkoholfria alternativ. En perfekt plats att hänga på en ljummen sommarkväll högt över Halmstad. Takterrassen kompletteras också med en vacker bar inne, så här kan du njuta av utsikten även dagar med sämre väder."
                                coordinates = Pair(56.669790709975445, 12.867039907683592)
                            })
                        })
                        subCategories.add(SubCategory().apply {
                            titleRes = R.string.subcategory_fika_title
                            points.add(POIItem().apply {
                                title = "Conditori Cecil"
                                description = "I över 70 år har det bakats bullar, bröd och bakelser på detta konditori. Att detta är ett mycket poppis ställe bland både laholmare och turister är inte så svårt att förstå, här är det nybakta fikabrödet tillverkat med kärlek och lokala råvaror och alla är överens om att fikat är dagens viktigaste mål."
                                coordinates = Pair(56.513186400000016, 13.043843299999946)
                            })
                            points.add(POIItem().apply {
                                title = "Vilgots surdegsbageri"
                                description = "I centrala Våxtorp ligger Vilgots surdegsbageri - ett kafé & hantverksbageri med fokus på surdeg, närproducerad & ekologiskt. En mötesplats med återvunnen & konstnärlig inredning. Här bjuds det på fika, lättare lunch, event & yoga vissa kvällar i veckan."
                                coordinates = Pair(56.41702070000001, 13.119932300000015)
                            })
                            points.add(POIItem().apply {
                                title = "Ysby gamla Lanthandel"
                                description = "Ysby gamla Lanthandel är ett litet lantligt café med gammaldags charm. Hembakade kakor och nybryggt kaffe, mackor och annat gott. Fika här med en känsla av att fika hos ”farmor” eller ta med dig hem."
                                coordinates = Pair(56.492546, 13.1149287)
                            })
                            points.add(POIItem().apply {
                                title = "Sockerbagaren"
                                description = "Sockerbagaren i Skummeslöv är ett mysigt bageri och café bara ett stenkast ifrån stranden. Här erbjuds hembakade bullar, bröd, småkakor, kaffebröd, och smörgåsar. Det går även att beställa goda tårtor, köpa glass och kolonialvaror. I caféet kan du avnjuta en kopp kaffe tillsammans med något gott från butiken - eller varför inte köpa med en god kaka till fikat på stranden?"
                                coordinates = Pair(56.46153979267341, 12.92140215986563)
                            })
                        })
                    })
                }
            }
            return inst as DummyHandler
        }
    }
    var categories:MutableList<Category> = mutableListOf()
}