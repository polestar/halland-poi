package com.example.varbergpoi.dummydata

import com.example.varbergpoi.R

class DummyHandler {
    companion object {
        private var inst: DummyHandler? = null
        fun getInstance(): DummyHandler {
            if (inst == null) {
                inst = DummyHandler().apply {
                    categories.add(
                        Category(
                            "Favoriter",
                            mutableListOf(),
                            R.drawable.favorite_points_icon
                        )
                    )
                    categories.add(
                        Category(
                            "Senaste",
                            mutableListOf(),
                            R.drawable.latest_points_icon
                        )
                    )
                    categories.add(
                        Category(
                            "Bekvämligheter",
                            mutableListOf(),
                            R.drawable.charging_stations_icon
                        )
                    )
                    categories.add(
                        Category(
                            "Mat & Dryck",
                            mutableListOf(),
                            R.drawable.local_dining_icon
                        ).apply {
                            subCategories.add(
                                SubCategory(
                                    "Restauranger",
                                    mutableListOf()
//                                    , R.drawable.restaurants_small_icon
                                ).apply {
                                    points.add(
                                        POIItem(
                                            "A little party",
                                            "Visste du att Halmstad har något så unikt som en champagnebar? Precis vid Nissans kajkant hittar du denna pärla, perfekt för dig som älskar champagne med noga utvalda tillbehör och välsmakande varmrätter. I kylarna hos A Little Party finns alltid mer än tvåhundra olika champagner och samtliga går att få på glas.",
                                            Pair(56.673635, 12.8594344)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Agave Glocal",
                                            "Ny mexikansk restaurang i Haverdal. Med en förkärlek för chili, närproducerade råvaror och det mexikanska köket slår nu Agave Glocal upp portarna och bjuder på burritos, tacos al Pastor och mängder av guacamole såklart.",
                                            Pair(56.730935, 12.6670906)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Asian Bank Office",
                                            "Här kan du räkna med ett Asian fusion-koncept som ligger helt rätt i tiden. De tilltalande sharing-rätterna är en fröjd för såväl öga som gom. Här grundas filosofin i att arbeta med så bra lokalproducerade råvaror som möjligt i samklang med de bästa asiatiska smakerna. Ett tips är att testa den japanska traditionen omakase som låter kocken bestämma. Omakase betyder helt enkelt ”I will leave it to you!”. Missa inte heller deras spännande och välarbetade drinkmeny med typiska smaker av Asien och svensk skog.",
                                            Pair(56.674391465644575, 12.858451008796692)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Bettans Bar",
                                            "Med havet som närmsta granne njuter du här av skaldjur, sushi och asiatisk fusion som en spännande kulinarisk twist. Nytänkande smaksensationer möter konstfulla matupplevelser som inte lämnar någon besviken. Bettans Bar är en av Hotel Tylösands restauranger och bjuder in till bubbliga luncher och välsmakande middagar. Säsongsöppet från försommaren till sensommaren.",
                                            Pair(56.6482979, 12.7291465)
                                        )
                                    )
                                })
                            subCategories.add(
                                SubCategory(
                                    "Pubar och barer",
                                    mutableListOf()
                                ).apply {
                                    points.add(
                                        POIItem(
                                            "Strandhotellet",
                                            "Varmt välkomna hem till Strandhotellet, där mat möter upplevelser som tillsammans blir ett. I den anrika byggnaden från 1927 kan du njuta av god mat & dryck i mysig miljö. Maten är inspirerad från alla världens kök, och passionen för mat och dryck speglas på din tallrik och drycken du har i glaset. De råvaror som serveras ifrån Strandhotellets meny är framtagna med största omsorg och ligger personalen varmast om hjärtat. Du kan också hyra bastun nere i sanddynerna med magisk utsikt över det böljande havet. Övriga aktiviteter finns det gott om för alla åldrar: shuffleboards, biljardbord, darttavlor, fotbollsspel och inte minst - en nybyggd äventyrsgolfbana.",
                                            Pair(56.514379870926234, 12.948337197303774)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "A little party",
                                            "Visste du att Halmstad har något så unikt som en champagnebar? Precis vid Nissans kajkant hittar du denna pärla, perfekt för dig som älskar champagne med noga utvalda tillbehör och välsmakande varmrätter. I kylarna hos A Little Party finns alltid mer än tvåhundra olika champagner och samtliga går att få på glas.",
                                            Pair(56.673635, 12.8594343)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Asian Bank Office",
                                            "Här kan du räkna med ett Asian fusion-koncept som ligger helt rätt i tiden. De tilltalande sharing-rätterna är en fröjd för såväl öga som gom. Här grundas filosofin i att arbeta med så bra lokalproducerade råvaror som möjligt i samklang med de bästa asiatiska smakerna. Ett tips är att testa den japanska traditionen omakase som låter kocken bestämma. Omakase betyder helt enkelt ”I will leave it to you!”. Missa inte heller deras spännande och välarbetade drinkmeny med typiska smaker av Asien och svensk skog.",
                                            Pair(56.674391465644575, 12.858451008796692)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Blue Skybar",
                                            "På nionde våningen på Halmstad Plaza hittar du Blue Skybar, en läcker takbar där terrassen ger en magisk vy över Laholmsbukten. Här serveras ett brett utbud av cocktails liksom flera smarriga alkoholfria alternativ. En perfekt plats att hänga på en ljummen sommarkväll högt över Halmstad. Takterrassen kompletteras också med en vacker bar inne, så här kan du njuta av utsikten även dagar med sämre väder.",
                                            Pair(56.669790709975445, 12.867039907683592)
                                        )
                                    )
                                })
                            subCategories.add(
                                SubCategory(
                                    "Caféer",
                                    mutableListOf()
                                ).apply {
                                    points.add(
                                        POIItem(
                                            "Conditori Cecil",
                                            "I över 70 år har det bakats bullar, bröd och bakelser på detta konditori. Att detta är ett mycket poppis ställe bland både laholmare och turister är inte så svårt att förstå, här är det nybakta fikabrödet tillverkat med kärlek och lokala råvaror och alla är överens om att fikat är dagens viktigaste mål.",
                                            Pair(56.513186400000016, 13.043843299999946)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Vilgots surdegsbageri",
                                            "I centrala Våxtorp ligger Vilgots surdegsbageri - ett kafé & hantverksbageri med fokus på surdeg, närproducerad & ekologiskt. En mötesplats med återvunnen & konstnärlig inredning. Här bjuds det på fika, lättare lunch, event & yoga vissa kvällar i veckan.",
                                            Pair(56.41702070000001, 13.119932300000015)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Ysby gamla Lanthandel",
                                            "Ysby gamla Lanthandel är ett litet lantligt café med gammaldags charm. Hembakade kakor och nybryggt kaffe, mackor och annat gott. Fika här med en känsla av att fika hos ”farmor” eller ta med dig hem.",
                                            Pair(56.492546, 13.1149287)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Sockerbagaren",
                                            "Sockerbagaren i Skummeslöv är ett mysigt bageri och café bara ett stenkast ifrån stranden. Här erbjuds hembakade bullar, bröd, småkakor, kaffebröd, och smörgåsar. Det går även att beställa goda tårtor, köpa glass och kolonialvaror. I caféet kan du avnjuta en kopp kaffe tillsammans med något gott från butiken - eller varför inte köpa med en god kaka till fikat på stranden?",
                                            Pair(56.46153979267341, 12.92140215986563)
                                        )
                                    )
                                })
                            subCategories.add(
                                SubCategory(
                                    "Glasställen",
                                    mutableListOf()
                                ).apply {
                                    points.add(
                                        POIItem(
                                            "Conditori Cecil",
                                            "I över 70 år har det bakats bullar, bröd och bakelser på detta konditori. Att detta är ett mycket poppis ställe bland både laholmare och turister är inte så svårt att förstå, här är det nybakta fikabrödet tillverkat med kärlek och lokala råvaror och alla är överens om att fikat är dagens viktigaste mål.",
                                            Pair(56.513186400000016, 13.043843299999946)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Vilgots surdegsbageri",
                                            "I centrala Våxtorp ligger Vilgots surdegsbageri - ett kafé & hantverksbageri med fokus på surdeg, närproducerad & ekologiskt. En mötesplats med återvunnen & konstnärlig inredning. Här bjuds det på fika, lättare lunch, event & yoga vissa kvällar i veckan.",
                                            Pair(56.41702070000001, 13.119932300000015)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Ysby gamla Lanthandel",
                                            "Ysby gamla Lanthandel är ett litet lantligt café med gammaldags charm. Hembakade kakor och nybryggt kaffe, mackor och annat gott. Fika här med en känsla av att fika hos ”farmor” eller ta med dig hem.",
                                            Pair(56.492546, 13.1149287)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Sockerbagaren",
                                            "Sockerbagaren i Skummeslöv är ett mysigt bageri och café bara ett stenkast ifrån stranden. Här erbjuds hembakade bullar, bröd, småkakor, kaffebröd, och smörgåsar. Det går även att beställa goda tårtor, köpa glass och kolonialvaror. I caféet kan du avnjuta en kopp kaffe tillsammans med något gott från butiken - eller varför inte köpa med en god kaka till fikat på stranden?",
                                            Pair(56.46153979267341, 12.92140215986563)
                                        )
                                    )
                                })
                            subCategories.add(
                                SubCategory(
                                    "Picknickställen",
                                    mutableListOf()
                                ).apply {
                                    points.add(
                                        POIItem(
                                            "Conditori Cecil",
                                            "I över 70 år har det bakats bullar, bröd och bakelser på detta konditori. Att detta är ett mycket poppis ställe bland både laholmare och turister är inte så svårt att förstå, här är det nybakta fikabrödet tillverkat med kärlek och lokala råvaror och alla är överens om att fikat är dagens viktigaste mål.",
                                            Pair(56.513186400000016, 13.043843299999946)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Vilgots surdegsbageri",
                                            "I centrala Våxtorp ligger Vilgots surdegsbageri - ett kafé & hantverksbageri med fokus på surdeg, närproducerad & ekologiskt. En mötesplats med återvunnen & konstnärlig inredning. Här bjuds det på fika, lättare lunch, event & yoga vissa kvällar i veckan.",
                                            Pair(56.41702070000001, 13.119932300000015)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Ysby gamla Lanthandel",
                                            "Ysby gamla Lanthandel är ett litet lantligt café med gammaldags charm. Hembakade kakor och nybryggt kaffe, mackor och annat gott. Fika här med en känsla av att fika hos ”farmor” eller ta med dig hem.",
                                            Pair(56.492546, 13.1149287)
                                        )
                                    )
                                    points.add(
                                        POIItem(
                                            "Sockerbagaren",
                                            "Sockerbagaren i Skummeslöv är ett mysigt bageri och café bara ett stenkast ifrån stranden. Här erbjuds hembakade bullar, bröd, småkakor, kaffebröd, och smörgåsar. Det går även att beställa goda tårtor, köpa glass och kolonialvaror. I caféet kan du avnjuta en kopp kaffe tillsammans med något gott från butiken - eller varför inte köpa med en god kaka till fikat på stranden?",
                                            Pair(56.46153979267341, 12.92140215986563)
                                        )
                                    )
                                })

                        })
                    categories.add(
                        Category(
                            "Badplatser",
                            mutableListOf(),
                            R.drawable.beaches_icon
                        )
                    )
                    categories.add(
                        Category(
                            "Aktiviteter",
                            mutableListOf(),
                            R.drawable.hiking_areas_icon
                        )
                    )
                    categories.add(
                        Category(
                            "Natur",
                            mutableListOf(),
                            R.drawable.nature_icon
                        )
                    )
                    categories.add(
                        Category(
                            "Kultur & Historia",
                            mutableListOf(),
                            R.drawable.culture_icon
                        )
                    )
                    categories.add(
                        Category(
                            "Samlingar",
                            mutableListOf(),
                            R.drawable.collections_icon
                        )
                    )
                }
            }
            return inst as DummyHandler
        }
    }

    var categories: MutableList<Category> = mutableListOf()
}

data class Category(
    var title: String,
    var subCategories: MutableList<SubCategory>,
    var iconRes: Int? = null
)

data class SubCategory(var title: String, var points: MutableList<POIItem>)
//, var iconRes: Int = R.drawable.restaurants_small_icon
data class POIItem(
    var title: String,
    var description: String,
    var coordinates: Pair<Double, Double>
) {
    override fun toString(): String {
        return title + " (" + coordinates.first.toString() + ", " + coordinates.second.toString() + ")"
    }
}