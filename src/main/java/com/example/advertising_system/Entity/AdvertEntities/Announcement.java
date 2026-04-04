package com.example.advertising_system.Entity.AdvertEntities;

import java.time.LocalDate;

import com.example.advertising_system.Entity.AdvertEntities.Target.AnTarget;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "announcements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertiser_id", nullable = false)
    private Advertiser advertiser;

    // === Неизменяемые поля (устанавливаются при создании) ===

    @Column(nullable = false)
    private int impressions;   

    @Column(nullable = false)
    private int clicks;       

    @Column(nullable = false, updatable = false)
    private double costPerImpression;   // цена за 1 показ

    @Column(nullable = false, updatable = false)
    private double costPerClick;        // цена за 1 переход

    @Column(nullable = false, updatable = false)
    private String title;               // название объявления

    @Column(nullable = false, updatable = false, length = 2000)
    private String text;                // текст объявления

    @Column(nullable = false, updatable = false)
    private LocalDate startDate;        // дата начала (не может быть в прошлом)

    @Column(nullable = false, updatable = false)
    private LocalDate endDate;          // дата окончания

    @OneToOne(mappedBy = "announcement", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private AnTarget antarget;

    // === Дополнительная логика ===

    // Конструктор для создания нового объявления (с проверкой дат)
    public Announcement(int impressions, int clicks, double costPerImpression,
                        double costPerClick, String title, String text,
                        LocalDate startDate, LocalDate endDate) {
        // Валидация
        if (startDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Дата начала не может быть в прошлом");
        }
        if (endDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Дата окончания не может быть в прошлом");
        }
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Дата начала не может быть позже даты окончания");
        }
        if (impressions < 0 || clicks < 0) {
            throw new IllegalArgumentException("Количество показов и переходов не может быть отрицательным");
        }

        this.impressions = impressions;
        this.clicks = clicks;
        this.costPerImpression = costPerImpression;
        this.costPerClick = costPerClick;
        this.title = title;
        this.text = text;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Метод проверки, активна ли кампания (текущая дата между startDate и endDate)
    public boolean isActive() {
        LocalDate now = LocalDate.now();
        return !now.isBefore(startDate) && !now.isAfter(endDate);
    }

    // Сеттеры для всех полей отсутствуют (кроме id, если нужно)
    // Чтобы Lombok не генерировал сеттеры для неизменяемых полей, используем @Setter(AccessLevel.NONE) на классе
}

/*
• Количество показов объявления (в момент входа пользователя в приложение
ему показывает реклама, это и считается показом). Не может меняться после
старта рекламной кампании.
• Количество переходов по объявлению (в момент, когда пользователь кликает
по объявлению, которое ему высветилось, происходит переход). Не может
меняться после старта рекламной кампании.
• Цена за 1 показ.
• Цена за 1 переход.
• Название объявления.
• Текст рекламного объявления.
• Дата начала действия включительно. Не может меняться после старта
рекламной кампании и не может быть в прошлом, но может быть текущим
днем.
• Дата окончания действия включительно. Не может меняться после старта
рекламной кампании и не может быть в прошлом, но может быть текущим
днем.
Старт рекламной кампании означает, что текущая дата в системе больше
либо равна дате начала рекламной кампании. Окончание рекламной кампании
означает, что текущая дата в системе меньше либо равна дате окончания
рекламной кампании.
В методах создания и обновления необходимо возвращать данные
по созданному или обновленному рекламному объявлению.
Рекламные объявления могут показываться пользователям только в даты их
действия, которые задаются в настройках.
Важно, что показы и переходы учитываются только по уникальным клиентам, то
есть если один клиент посмотрел на объявление 2 раза, то для рекламодателя
это 1 показ.
*/