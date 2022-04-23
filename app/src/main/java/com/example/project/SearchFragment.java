package com.example.project;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    public static int num;
    public static ArrayList<SearchItem> names = new ArrayList<SearchItem>();
    public static ArrayList<NovelData> novelData = new ArrayList<NovelData>();
    RecyclerView recyclerView;
    SearchAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        List of novels for the RecyclerView
        names.add(new SearchItem("The Way to Protect the Female Lead's Older Brother", "This Concubine is in Shanyang (妾在山阳)"));
        names.add(new SearchItem("Omniscient Reader's Viewpoint", "Sing-Shong (싱숑)"));
        names.add(new SearchItem("Trash of the Count's Family", "Yoo Ryeo Han (유려한)"));
        names.add(new SearchItem("Non-Human Sub-District", "Zui Yi Chang Ge (醉饮长歌)"));
        names.add(new SearchItem("Death is the Only Ending for the Villainess", "Kwon Gyo Eun (권겨을)"));
        names.add(new SearchItem("Don't Pick Up Boyfriends from the Trash Bin", "Riding a Whale South (骑鲸南去)"));
        names.add(new SearchItem("Heaven Official's Blessing", "Mò Xiāng Tóngxiù (墨香铜臭)"));
        names.add(new SearchItem("Husky and His White Cat Shizun", "Meatbun Doesn't Eat Meat (肉包不吃肉)"));
        names.add(new SearchItem("Little Cockroach", "Bowl of Porrige (一碗粥)"));
        names.add(new SearchItem("So I'm a Spider, So What", "Baba Okina"));
        names.add(new SearchItem("Game Loading", "Long Qi (龙柒)"));
        names.add(new SearchItem("Thousand Autumns", "Meng Xi Shi (梦溪石)"));
        names.add(new SearchItem("Fake Slackers", "Mu Gua Huang (木瓜黄)"));
        names.add(new SearchItem("The Founder of Diabolism", "Mò Xiāng Tóngxiù (墨香铜臭)"));
        names.add(new SearchItem("To Be a Heartthrob in a Horror Movie", "Jia Zhi Yu (姜之鱼)"));
        names.add(new SearchItem("Xia Niangniang", "Xi Ni (洗泥)"));
        names.add(new SearchItem("Qiang Jinjiu", "Tang Jiuqing (唐酒卿)"));
        names.add(new SearchItem("Case File Compendium", "Meatbun Doesn't Eat Meat (肉包不吃肉)"));
        names.add(new SearchItem("Flying Gulls Never Land", "Hui Nan Que (回南雀)"));
        names.add(new SearchItem("The Story of Two Mosquitoes", "Nai Xiao Ning (奶小寧)"));
        names.add(new SearchItem("Kaleidoscope of Death", "Xi Zixu (西子绪)"));

//        List of novels for the novel fragment
        novelData.add(new NovelData(0, "The Way to Protect the Female Lead's Older Brother","여주인공의 오빠를 지키는 방법",
                "Kin (킨)","Completed","209","40",
                "I accidentally took possession of someone in a 19+ reverse harem novel.\n" +
                        "\n " +
                        "The problem is that I became Roxana Agriche, the older sister of the sub-villain. My damn father kidnapped the heroine’s brother. Now, is the only thing left to meet a terrible end from the vengeance of the heroine?\n" +
                        "\n" +
                        "But what if I can avoid that horrible development?\n" +
                        "\n" +
                        "“I’m also interested in this toy.”\n" +
                        "\n" +
                        "“I’ll protect you until you can get out of here safely.”\n" +
                        "\n" +
                        "The heroine’s brother, Cassis Pedalian, will definitely be able to pay me back later."));

        novelData.add(new NovelData(1, "Omniscient Reader's Viewpoint",                     "전지적 독자 시점",
                "Sing-Shong (싱숑)", "Completed","516","35",
                "Kim Dokja does not consider himself the protagonist of his own life. Befitting the name his parents gave him, he is a solitary person whose sole hobby is reading web novels. For over a decade, he has lived vicariously through Yu Junghyeok, the main character of the web novel Three Ways to Survive the Apocalypse (TWSA).\n" +
                        "\n" +
                        "Through Junghyeok, Dokja has experienced secondhand the trials of repeatedly regressing in time, in search of an end to life-threatening “scenarios” that force people to act out narratives for the amusement of god-like “Constellations.”\n" +
                        "\n" +
                        "After reading 3,149 chapters—long after all other readers lost interest—Dokja finally resigns himself to the story ending. However, he receives an enigmatic message from the author, stating that the story will soon be monetized, before his surroundings suddenly go dark.\n" +
                        "\n" +
                        "He swiftly realizes that fiction has become reality and he is now living through TWSA. Although he is the singular omniscient reader of the events yet to come, his success in the scenarios is not guaranteed—but perhaps his advantage will empower him to step into the protagonist role that never suited him before."));

        novelData.add(new NovelData(2, "Trash of the Count's Family",                       "백작가의 망나니가 되었다",
                "Yoo Ryeo Han (유려한)","Ongoing","786",
                "When I opened my eyes, I was inside a novel.\n" +
                        "\n" +
                        "[The Birth of a Hero].\n" +
                        "[The Birth of a Hero] was a novel focused on the adventures of the main character, Choi Han, a high school boy who was transported to a different dimension from Earth, along with the birth of the numerous heroes of the continent.\n" +
                        "I became a part of that novel as the tr*sh of the Count’s family, the family that oversaw the territory where the first village that Choi Han visits is located.\n" +
                        "\n" +
                        "The problem is that Choi Han becomes twisted after that village, and everyone in it, is destroyed by assassins.\n" +
                        "\n" +
                        "The bigger problem is the fact that this s*upid tr*sh who I’ve become doesn’t know about what happened in the village and messes with Choi Han, only to get beaten to a pulp.\n" +
                        "\n" +
                        "“…This is going to be a problem.”\n" +
                        "\n" +
                        "I feel like something serious has happened to me.\n" +
                        "\n" +
                        "But it was worth trying to make this my new life."));

        novelData.add(new NovelData(3, "Non-Human Sub-District",                            "非人类街道办",
                "Zui Yi Chang Ge (醉饮长歌)", "Completed","82", "4",
                "Lin Mu rescued a Samoyed.\n" +
                        "\n" +
                        "Capable of eating, smiling, has a high IQ. Picks up anything you teach him quickly, a good helper around the house.\n" +
                        "\n" +
                        "The only thing was that he doesn’t bark nor wag his tail.\n" +
                        "\n" +
                        "Lin Mu took a ham sausage and coaxed for the thousandth time, “wag your tail, and this ham sausage is yours to eat.”\n" +
                        "\n" +
                        "The Samoyed raised his eyes impatiently, and with a single shake of his tail, shook out nine.\n" +
                        "\n" +
                        "Lin Mu: …… F*ck.\n" +
                        "\n" +
                        "Afterwards, the fox that did not wish to reveal his name, Mr. Yan Xuanjing, said in an interview: “Now I regret, I deeply regret. At that time, I shouldn’t have pretended to be a dog to take advantage of him, shouldn’t have touched him, rubbed against him, eaten his food and slept in his bed. Now I have a home that I can’t return to and a wife I can’t sleep with, I regret, deeply regret.”"));

        novelData.add(new NovelData(4, "Death is the Only Ending for the Villainess",       "악역의 엔딩은 죽음뿐",
                "Kwon Gyo Eun (권겨을)", "Completed", "231", "48",
                "I’ve reincarnated as the reverse harem game’s villainess, the one and only adopted daughter of the ducal Eckart family.\n" +
                        "\n" +
                        "But the difficulty just has to be the worst!\n" +
                        "\n" +
                        "Everything I do will only lead me to death.\n" +
                        "\n" +
                        "I must be paired with one of the main male characters from the heroine’s harem before the ‘real daughter’ of the duke family appears!\n" +
                        "\n" +
                        "Two older brothers who always pick a fight with me on every little thing.\n" +
                        "\n" +
                        "The insane crown prince whose route will always lead to my death.\n" +
                        "\n" +
                        "‘I only see the heroine and no one else’s wizard, and also her loyal s*ave knight, too!\n" +
                        "\n" +
                        "‘First, let’s take some of them which I see no hope in, out of the list!’\n" +
                        "\n" +
                        "“I didn’t know my place up until now. From now on, I’ll live as quiet as a mouse so you wouldn’t care the slightest bit!\n" +
                        "\n" +
                        "But why do their interests in me keep on rising every time I draw the line?!"));

        novelData.add(new NovelData(5, "Don't Pick Up Boyfriends from the Trash Bin",       "不要在垃圾桶里捡男朋友[快穿]",
                "Riding A Whale South (骑鲸南去)","Completed", "270", "13",
                "Chi Xiaochi: fourth-rate citizen at birth, three-time award-winning film emperor, second-rate temper, first-class looks.\n" +
                        "\n" +
                        "He crawled his way out of hell on hard mode to become a winner at life.\n" +
                        "\n" +
                        "Then, he was smashed into a vegetative state by a chandelier.\n" +
                        "\n" +
                        "061: Hello, here’s a brief rundown on the scum gong reconditioning system. This system measures the regret level of the scum gong. Every time their regret level reaches one hundred points, you will be able to leave the current world. A friendly tip, usually, through dedication and self-sacrifice, our employees slowly foster a sense of dependency in the scum gongs, gradually making it so the scum gongs can’t live without them.\n" +
                        "\n" +
                        "Chi Xiaochi: How many regret points is a complete loss of reputation and standing worth? How about a fall from grace? Or wanting something but never being able to obtain it?\n" +
                        "\n" +
                        "061: ……"));

        novelData.add(new NovelData(6, "Heaven Official's Blessing",                        "天官赐福",
                "Mo Xiang Tong Xiu (墨香铜臭)", "Completed","244", "8",
                "Eight hundred years ago, Xie Lian was the Crown Prince of the Xian Le kingdom. He was loved by his citizens and was considered the darling of the world. He ascended to the Heavens at a young age; however, due to unfortunate circumstances, was quickly banished back to the mortal realm. Years later, he ascends again–only to be banished again a few minutes after his ascension.\n" +
                        "\n" +
                        "Now, eight hundred years later, Xie Lian ascends to the Heavens for the third time as the laughing stock among all three realms. On his first task as a god thrice ascended, he meets a mysterious ghost who rules over the ghosts and terrifies the Heavens, yet, unbeknownst to Xie Lian, this ghost king has been paying attention to him for a very, very long time."));

        novelData.add(new NovelData(7, "The Husky and His White Cat Shizun",                "二哈和他的白猫师尊",
                "Meatbun Doesn't Eat Meat (肉包不吃肉)","Completed", "311", "39",
                "Mo Ran thought becoming Chu Wanning’s disciple was a mistake.\n" +
                        "\n" +
                        "His shizun was really too much like a cat while he himself was a dumb pup who’d only slobber and wag his tail.\n" +
                        "\n" +
                        "Dogs and cats were different by nature; originally, the dumb pup didn’t want to reach his furry paws out to that cat.\n" +
                        "\n" +
                        "At first he thought, dogs should be with dogs, like his shixiong, beautiful and tame like a cute Japanese Spitz, and the two of them together would surely be a match made in heaven.\n" +
                        "\n" +
                        "Yet, after having died and reborn, after having lived two lives, the one he hauled back each time to his den in the end was always the one he couldn’t stand at first: that snow-white kitty shizun."));

        novelData.add(new NovelData(8, "Little Cockroach",                                  "小蟑螂",
                "Bowl of Porrige (一碗粥)","Completed","1", "2",
                "The story between a little c*ckroach and a hottie (帅哥)."));

        novelData.add(new NovelData(9, "So I'm a Spider, So What",                          "蜘蛛ですが、なにか?",
                "Baba Okina","Completed", "331", "269",
                "The world where the Hero and the Demon King continue to oppose each other. The grand magic from the Hero and the Demon King cross over worlds and exploded in the classroom of a certain high school.\n" +
                        "\n" +
                        "The students who died in the explosion will be reincarnated in a different world. The protagonist, who had the lowest reputation in the class, was reincarnated into a spider. Nevertheless, she adapted quickly to the present condition with strong willpower.\n" +
                        "\n" +
                        "This is a story of she who has become a spider trying whatever she can to live."));

        novelData.add(new NovelData(10, "Game Loading",                                     "游戏加载中",
                "Long Qi (龙柒)","Completed","304", "5",
                "Xie Xi was someone with luck off the charts! The advantage was that any game could be easily cleared. The disadvantage was that all games were boring! Then one day, the words ‘Game loading’ appeared in front of his eyes and he began to clear real games!\n" +
                        "\n" +
                        "The emperor of luck ran into a bottleneck in the first game.\n" +
                        "\n" +
                        "Game Name: Love to the Left or Right\n" +
                        "\n" +
                        "The vampire prince has invited you to a meal. Will you go?\n" +
                        "\n" +
                        "Xie Xi: I won’t go.\n" +
                        "\n" +
                        "Arrow through the heart. The vampire prince says you can’t leave him and takes your life.\n" +
                        "\n" +
                        "After loading the file, Xie Xi changed the option: I will go.\n" +
                        "\n" +
                        "The housekeeper has cut off your head because of love and hatred.\n" +
                        "\n" +
                        "Xie Xi: ???"));

        novelData.add(new NovelData(11, "Thousand Autumns",                                 "千秋",
                "Meng Xi Shi (梦溪石)","Completed", "128", "13",
                "Yan Wushi had walked a path full of blood and corpses.\n" +
                        "\n" +
                        "He did not believe in the good nature of humanity. Even more so, he did not believe that there could be someone with great kindness and sense of justice, who would be so considerate of others without asking anything in return.\n" +
                        "\n" +
                        "One day, Shen Qiao, who was the sect leader of Mount Xuandu, the number one Daoist sect under the heavens, was challenged to a duel but somehow fell off the cliff.\n" +
                        "\n" +
                        "Yan Wushi happened to pass by down there.\n" +
                        "\n" +
                        "Seeing Shen Qiao who was seriously injured to the point of dying, he suddenly came up with a perfect idea…\n" +
                        "\n" +
                        "After thousands of autumns, who could stay eternal?"));

        novelData.add(new NovelData(12, "Fake Slackers",                                    "伪装学渣",
                "Mu Gua Huang (木瓜黄)","Completed", "112", "3",
                "After class placements were decided, the school’s two infamous ‘problem youths’ not only shared the same class, but the same desk.\n" +
                        "\n" +
                        "They’re clearly good at studies, but pretend to be slackers. Fakers from head to toe who just keep walking farther down the path of their performance.\n" +
                        "\n" +
                        "Heard through the grapevine about the two big brothers who always fight over the last place in class.\n" +
                        "\n" +
                        "Basically, this is a serious comedy. About the little matters of growing up."));

        novelData.add(new NovelData(13, "The Founder of Diabolism",                         "魔道祖師",
                "Mo Xiang Tong Xiu (墨香铜臭)","Completed", "113", "13",
                "As the grandmaster of demonic cultivation, Wei Wuxian roamed the world, hated by millions for committing acts of necromancy. Overthrown by the powerful clans he had attempted to subjugate, Wei Wuxian is supposedly killed by his shidi in order to save the cultivation world.\n" +
                        "\n" +
                        "Restored to life in the body of Mo Xuanyu, the local cut-sleeve lunatic, in order to exact revenge on his abusive relatives, Wei Wuxian quickly finds himself spiralling back into his old life when he’s taken away by the cold-hearted, stern, and ultimately quite boring Lan Wangji – who might be harbouring warmer feelings than contempt. Perhaps of the…romantic kind?\n" +
                        "\n" +
                        "But despite his new beginning, Wei Wuxian begins to unravel a decade and a half long mystery that is set to undo the very fabric of the cultivation world as they know it.\n" +
                        "\n" +
                        "A mysterious, action-packed thriller of a ride, this is a journey you won’t want to miss!"));

        novelData.add(new NovelData(14, "To Be a Heartthrob in a Horror Movie",             "在恐怖片里当万人迷[快穿]",
                "Jiang Zhi Yu (姜之鱼)", "Completed", "156",
                "Holographic viewing technology allowed audience members to enter a movie and personally experience it for themselves. Naturally, romance movies were the most popular and well-received, while nobody was interested in horror movies.\n" +
                        "\n" +
                        "Su Min was the first of the viewers to experience a horror movie.\n" +
                        "\n" +
                        "Later–\n" +
                        "\n" +
                        "Malicious Spirit: I dare not scare nor frighten my sweetheart…\n" +
                        "\n" +
                        "Su Min: Actually, horror movies aren’t scary at all.\n" +
                        "\n" +
                        "Audience: No, no, no, you are playing in a romance movie! (Loudly)\n" +
                        "\n" +
                        "The audience suddenly discovered that the recent rerelease of the horror movie was much better than the original. Furthermore, to everyone’s surprise, the ghost was very sweet…"));

        novelData.add(new NovelData(15, "Xia Niangniang",                                   "瞎娘娘",
                "Xi Ni (洗泥)","Completed", "29",
                "A blind concubine lives in the cold palace. The blind concubine has a snow white cat. Day after day, year after year, he lives quietly in the courtyard of the cold palace. It is as if he has already been forgotten by the entire imperial palace. Until one day, the young emperor accidentally chances upon him…"));

        novelData.add(new NovelData(16, "Qiang Jin Jiu",                                    "将进酒",
                "Tang Jiuqing (唐酒卿)","Completed", "282",
                "The six prefectures of Zhongbo were offered to foreign enemies on a silver platter, and Shen Zechuan was taken into custody in the capital, reduced to a drowning dog* loathed and condemned by all. Xiao Chiye followed the scent of the furor and made his way over. But instead of setting others on him, he kicked Shen Zechuan with his very own leg, rendering the latter an invalid. Who would expect this invalid to turn around and bite him in a counterattack until he was all drenched in blood? That was the start of an epic feud between both men who tore at each other every time they come face-to-face with one another.\n" +
                        "\n" +
                        "“Fate wants to bind me here for life, but this is not the path I choose. The yellow dust submerged my brothers deep under. I have no wish to bow in submission to an illusory fate. The imperial edict can’t save my troops, and the imperial court can’t fill the stomachs of my mounts. I’m no longer willing to lay down my life for this purpose. I want to surmount that mountain. I am going to fight for myself.”\n" +
                        "\n" +
                        "Note: a drowning dog is someone who is down and out, having lost favor or power."));

        novelData.add(new NovelData(17, "Case File Compendium",                             "病案本",
                "Meatbun Doesn't Eat Meat (肉包不吃肉)","Ongoing", "243",
                "Despicable, insane gong x paternal and indifferent, divorced shou. The story between a youth with a unique psychological disorder and an apathetic doctor."));

        novelData.add(new NovelData(18, "Flying Gulls Never Land",                          "飞鸥不下",
                "Hui Nan Que (回南雀)","Completed","73","9",
                "“I went to prison for ten years for him, and not once did he come to see me.”\n" +
                        "\n" +
                        "While he was explaining the questions to me, I always admired the view of his side profile, seeing how the sunlight would hit his fluttering eyelashes, casting faint shadows just beneath his irises.\n" +
                        "\n" +
                        "Every time I was entranced by his good looks, I would marvel at whether his biological parents were fools, because how could a normal person abandon such a handsome and healthy boy.\n" +
                        "\n" +
                        "From then on, I believed the deep affection I couldn’t push aside for him was just the attachment I felt for an older brother, a dependency born from the lack of a father figure in my life.\n" +
                        "\n" +
                        "Until the appearance of Qi Yang.\n" +
                        "\n" +
                        "“The only difference between me and Sheng Min Ou’s harasser, is probably the fact that I call Sheng Min Ou ‘Older brother’”"));

        novelData.add(new NovelData(19, "The Story of Two Male Mosquitoes",                 "两只公蚊子的故事",
                "Nai Xiao Ning (奶小寧)","Completed","1",
                "N/A"));

        novelData.add(new NovelData(20, "Kaleidoscope of Death",                            "死亡万花筒",
                "Xi Zixu (西子绪)","Completed","139","10",
                "It started off peculiarly; first, his domestic cat refused to let him cuddle it.\n" +
                        "\n" +
                        "Lin Qiushi soon found that a sense of disharmony and incongruity began to pervade everything around him.\n" +
                        "\n" +
                        "Then, one odd day, he pushed open a door, and he discovered that the hallway he was familiar with turned into a boundless corridor.\n" +
                        "\n" +
                        "At both ends of this corridor were twelve, identical iron gates.\n" +
                        "\n" +
                        "Thus, the story began.\n" +
                        "\n" +
                        "Ruan Nanzhu said to Lin Qiushi, “When you gaze into the abyss, the abyss gazes back.”\n" +
                        "\n" +
                        "Upon hearing this, Lin Qiushi sank into deep contemplation. He then pulled down the zipper of his trousers and aimed at the abyss…\n" +
                        "\n" +
                        "Ruan Nanzhu: “…Put your pants on properly!”"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new SearchAdapter(names);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new SearchAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                num = position;

//                pull data from DB based on the novelID
//                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity().getApplicationContext());
//                databaseAccess.open();
//
//                novelData = databaseAccess.returnData(position);
//                databaseAccess.close();

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, new NovelFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return rootView;
    }
}