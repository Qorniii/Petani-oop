package com.mycompany.game;

import java.util.Random;

public class Game {


    public static void main(String[] args) {
        // Membuat karakter hero
        Hero hero = new Hero("Saipul", 100, 100);

        // Membuat karakter musuh
        Enemy enemy = new Enemy("Zevana", 50, 50);

        // Pertempuran antara hero dan musuh
        while (!hero.isDead() && !enemy.isDead()) {
            // Hero menyerang musuh
            hero.attack(enemy);

            // Musuh menyerang hero
            if (!enemy.isDead()) {
                enemy.attack(hero);
            }

            // Menampilkan status setiap kali setelah serangan
            System.out.println("Hero: " + hero.getStatus());
            System.out.println("Enemy: " + enemy.getStatus());
            System.out.println("------------------------------");
        }

        // Menentukan pemenang
        if (hero.isDead()) {
            System.out.println(hero.getName() + " is Dead, Game Over :( ");
        } else {
            System.out.println("Congratulations! " + hero.getName() + " defeated the enemy!");
        }
    }
}

class Character {
    private final String name;
    private int health;
    private final int attackPower;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public String getStatus() {
        return name + " - Health: " + health;
    }

    public void attack(Character opponent) {
        Random random = new Random();
        int damage = random.nextInt(attackPower) + 1;
        opponent.takeDamage(damage);
        System.out.println(name + " attacked " + opponent.getName() + " for " + damage + " damage!");
    }
}

class Hero extends Character {
    public Hero(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // Tambahan fitur atau metode khusus untuk hero bisa dimasukkan di sini
}

class Enemy extends Character {
    public Enemy(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    
    // Tambahan fitur atau metode khusus untuk hero bisa dimasukkan di sini
}
