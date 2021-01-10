package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private int timeSeconds;
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){

//        Метод должен:
//        2.2. Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду.
//         (Пока делать не нужно, сделаем позже).
        List<Advertisement> advertisementList = storage.list();
        List<Advertisement> listToWatch = new ArrayList<>();

        Collections.sort(advertisementList, ((Comparator<Advertisement>) (o1, o2)
                -> (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying()))
                .thenComparing((o1, o2) -> o2.getDuration() - o1.getDuration()));

        for (Advertisement advertisement : advertisementList){
            if (timeSeconds - advertisement.getDuration() >= 0 && advertisement.getHits() > 0){
                listToWatch.add(advertisement);
                timeSeconds = timeSeconds - advertisement.getDuration();
                advertisement.revalidate();
            }
        }

//        2.3. Если нет рекламных видео, которые можно показать посетителю, то бросить NoVideoAvailableException,
//        которое перехватить в оптимальном месте (подумать, где это место)
//         и с уровнем Level.INFO логировать фразу "No video is available for the order " + order

        if (listToWatch.isEmpty()){
            throw new NoVideoAvailableException();
        }
//        2.4. Отобразить все рекламные ролики, отобранные для показа,
//        в порядке уменьшения стоимости показа одного рекламного ролика в копейках.
//        Вторичная сортировка - по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки.
//                Используй метод Collections.sort
//
//        Пример для заказа [WATER]:
//        First Video is displaying... 50, 277
//        где First Video - название рекламного ролика
//        где 50 - стоимость показа одного рекламного ролика в копейках
//        где 277 - стоимость показа одной секунды рекламного ролика в тысячных частях копейки (равно 0.277 коп)
//        Используй методы из класса Advertisement.
//        (Этот пункт тоже пока делать не нужно, сделаем позже).
        Collections.sort(listToWatch, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            }
        }.thenComparing(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (int) (o1.getAmountPerOneDisplaying() - o2.getAmountPerOneDisplaying());
            }
        }));

        for (Advertisement advertisement : listToWatch){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(advertisement.getName());
            stringBuilder.append(" is displaying... ");
            stringBuilder.append(advertisement.getAmountPerOneDisplaying());
            stringBuilder.append(", ");
            stringBuilder.append(advertisement.getAmountPerOneDisplaying() * 1000/ advertisement.getDuration());
            ConsoleHelper.writeMessage(stringBuilder.toString());
        }

    }
}
