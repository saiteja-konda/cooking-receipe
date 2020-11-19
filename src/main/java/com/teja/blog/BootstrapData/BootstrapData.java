package com.teja.blog.BootstrapData;

import com.github.javafaker.Faker;
import com.teja.blog.model.Category;
import com.teja.blog.model.Post;
import com.teja.blog.model.Subcribers;
import com.teja.blog.repository.CategoryRepository;
import com.teja.blog.repository.PostRepository;
import com.teja.blog.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class BootstrapData implements CommandLineRunner {
    @Autowired
    public PostRepository postRepository;
    @Autowired
    public CategoryRepository categoryRepository;
    long generatedLong = new Random().nextLong();
    @Autowired
    public SubscriberRepository subscriberRepository;


    @Override
    public void run(String... args) throws Exception {

//        System.out.println("Started in Faker");
        Faker faker = new Faker();
        String[] Type = {"Featured", "News", "Latest", "Trending"};
        String[] Genre = {"Music", "Entertainment", "Health", "Technology", "Events", "Facts", "Music", "Entertainment", "Health", "Technology", "Events", "Facts"};
        String[] CData = {"Music", "Entertainment", "Health", "Technology", "Events", "Facts"};

        String[] Email = {"nisi@molestieSedid.com",
                "mauris@malesuada.com",
                "velit.Aliquam@Mauris.ca",
                "ornare.In@nisl.net",
                "lorem.auctor.quis@acmattisornare.ca",
                "erat@quis.net",
                "nunc.id@Curabituregestas.ca",
                "ac@Cras.org",
                "nec.mollis@tristique.org",
                "diam@Nuncmaurissapien.ca",
                "ut.aliquam.iaculis@Aliquamultricesiaculis.ca",
                "ut.molestie.in@erateget.com",
                "non.quam.Pellentesque@feugiatnec.com",
                "Nulla.tincidunt@tempor.edu",
                "egestas.hendrerit@dapibusid.co.uk",
                "parturient.montes.nascetur@Vivamusnon.com",
                "rutrum.non.hendrerit@maurisrhoncus.co.uk",
                "elementum.lorem.ut@tellussemmollis.edu",
                "dolor.elit@elementumdui.co.uk",
                "risus.Donec.egestas@Pellentesquehabitantmorbi.com",
                "Ut.sagittis.lobortis@apurusDuis.net",
                "est.ac.facilisis@Phasellusornare.com",
                "lobortis.Class@eleifendvitae.co.uk",
                "molestie.in.tempus@et.com",
                "rutrum.eu.ultrices@quam.net",
                "aliquet.lobortis@feugiatplacerat.ca",
                "Pellentesque@dolortempus.net",
                "risus.Donec.egestas@luctuset.com",
                "egestas@adipiscinglacus.org",
                "hendrerit@tincidunttempus.org",
                "Vivamus@estNunclaoreet.edu",
                "Etiam.ligula.tortor@et.ca",
                "a@auctorvelit.co.uk",
                "penatibus.et.magnis@consequatpurusMaecenas.com",
                "tortor.nibh@arcu.co.uk",
                "pede@purussapiengravida.net",
                "mi.Duis.risus@Aliquameratvolutpat.co.uk",
                "est.vitae.sodales@Curabiturconsequatlectus.net",
                "dolor.sit.amet@Maurisutquam.net",
                "a.odio@eget.com",
                "lobortis.risus.In@atsemmolestie.ca",
                "magna.Lorem@nec.ca",
                "felis.ullamcorper@Duis.ca",
                "facilisis.vitae.orci@eleifendnecmalesuada.ca",
                "consequat.auctor@egetvenenatis.ca",
                "amet.massa@acipsumPhasellus.org",
                "augue.malesuada.malesuada@sociisnatoquepenatibus.com",
                "non.hendrerit@purus.edu",
                "in@etnetuset.org",
                "Nunc.mauris@Nullamsuscipit.net",
                "congue@sitametfaucibus.net",
                "cursus.purus.Nullam@dolordapibusgravida.net",
                "penatibus.et.magnis@disparturientmontes.net",
                "ac@nuncsed.net",
                "lectus@sitametconsectetuer.org",
                "Suspendisse.tristique.neque@etrutrumeu.co.uk",
                "pede@aliquetmolestietellus.net",
                "turpis@eu.edu",
                "Sed@rhoncusid.ca",
                "Nunc.lectus@vulputate.co.uk",
                "lacus.Quisque@tempor.edu"};
        String[] Name = {
                "Ray Long",
                "Clinton Levine",
                "Leroy Dotson",
                "Gray Cox",
                "Harding Meyer",
                "Axel Knowles",
                "Lance Frost",
                "Callum Garrett",
                "Dustin Barnett",
                "Jameson Sullivan",
                "Uriel Fuentes",
                "Zane Thomas",
                "Mason Donovan",
                "Neil Oneil",
                "Blake Garcia",
                "Kadeem Owens",
                "Caesar Warren",
                "Todd Chambers",
                "Hashim Ayala",
                "Flynn Baldwin",
                "Lester Snow",
                "Quamar Hale",
                "Mohammad Glass",
                "Baker Hayden",
                "Caesar Haley",
                "Paul Williamson",
                "Ray Norton",
                "Zeus Rivera",
                "Adam Stein",
                "Sylvester Robbins",
                "Vance Moran",
                "Fletcher Wolfe",
                "Zeph Walls",
                "Bradley Mcintyre",
                "Rahim Becker",
                "Asher Green",
                "Stewart Pace",
                "Salvador Gentry",
                "Steven Shepherd",
                "Quinn Velez",
                "Colorado Hubbard",
                "Barrett Franklin",
                "Ali Peters"};
        Random r = new Random();
        int randomType = r.nextInt(Type.length);

//        for (int x = 0; x < CData.length; x++) {
//            Category category = new Category();
//            System.out.println(CData[x]);
//            category.setName(CData[x]);
//            categoryRepository.save(category);
//        }
//        for (int i = 0; i < 30; i++) {
//            int index = (int) (Math.random() * 4);
//            int index2 = (int) (Math.random() * 12);
//
//            Post post = new Post();
//            post.setTitle(faker.rickAndMorty().character() + " " + faker.chuckNorris().fact());
//            post.setContent(faker.lorem().paragraph(80));
//            post.setDescription(faker.lorem().sentence(15));
//            post.setCategoryId(faker.number().numberBetween(1L, 6L));
//            post.setImageUrl("https://picsum.photos/id/" + i + "/1265/1080");
//            post.setThumbnailImageUrl("https://picsum.photos/id/" + i + "/825/500");
//            post.setType(Type[index]);
//            post.setGenre(Genre[index2]);
//
//            post.setViews(faker.number().numberBetween(100, 600));
//
//            post.setLikes(faker.number().numberBetween(1, 15));
//
//            post.setSad(faker.number().numberBetween(1,15));
//
//            post.setSuperb(faker.number().numberBetween(1,15));
//
//            post.setAngery(faker.number().numberBetween(1,5));
//
//            post.setLaugh(faker.number().numberBetween(1,15));
//
//            post.setWow(faker.number().numberBetween(1,15));
//
//            System.out.println(post);
//            postRepository.save(post);
//
//        }
//
//        for (int i = 0; i < 26; i++) {
//            Subcribers subcribers = new Subcribers();
//            subcribers.setName(Name[i]);
//            subcribers.setEmail(Email[i]);
//            System.out.println(subcribers);
//            subscriberRepository.save(subcribers);
//
//
//        }

        System.out.println("Fake Posts count" + postRepository.count());
        System.out.println("Fake Subscribers count" + subscriberRepository.count());
        System.out.println("Fake Categoried count" + categoryRepository.count());

    }
}
