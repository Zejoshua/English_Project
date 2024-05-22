package com.proyectoIngles.adjetivosFormas.Model;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OperatorsAdjective {
    private ArrayList<Adjective> listAdverbs;

    public OperatorsAdjective() {
        this.listAdverbs = readArchiveCSV();
    }

    public ArrayList<Adjective> getListAdverbs() {
        return listAdverbs;
    }

    public ArrayList<Adjective> readArchiveCSV() {
        ArrayList<Adjective> list = new ArrayList<>();
        String archive = "G:/Practicas de paradigmas 2/adjetivosFormas/adjetivosFormas/adjectivesProgram.csv";
        try (CSVReader reader = new CSVReader(new FileReader(archive))) {
            reader.skip(1);
            List<String[]> data = reader.readAll();
            for (String[] row : data) {
                int id = Integer.parseInt(row[0]);
                String adjective = row[1];
                String comparative = row[2];
                String superlative = row[3];
                String exampleComparative = row[4];
                String exampleSuperlative = row[5];
                list.add(new Adjective(id, adjective, comparative, superlative, exampleComparative, exampleSuperlative));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Adjective> search(String word) {
        Predicate<Adjective> filter = adjective -> adjective.getAdjective().equalsIgnoreCase(word);
        return listAdverbs.parallelStream().filter(filter).collect(Collectors.toCollection(ArrayList::new));
    }

    public void addNewAdjective(Adjective adjective) {
        int newNumber = listAdverbs.size() + 1;
        adjective.setId(newNumber);
        listAdverbs.add(adjective);
        saveAdjectivesToCSV();
        listAdverbs = readArchiveCSV();
    }

    private void saveAdjectivesToCSV() {
        String archive = "G:/Practicas de paradigmas 2/adjetivosFormas/adjetivosFormas/adjectivesProgram.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true))) {
            Adjective lastAdjective = listAdverbs.get(listAdverbs.size() - 1);
            bw.write(lastAdjective.getId() + "," + lastAdjective.getAdjective() + "," + lastAdjective.getComparative() + "," + lastAdjective.getSuperlative() + "," + lastAdjective.getExampleComparative() + "," + lastAdjective.getExampleSuperlative());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String ReturnExampleComparative(String letra) {
        Optional<String> exampleComparative = listAdverbs.stream()
                .filter(adjective -> adjective.getAdjective().equalsIgnoreCase(letra))
                .map(Adjective::getExampleComparative)
                .findFirst();

        return exampleComparative.orElse(null);
    }

    public String ReturnExampleSuperlative(String letra) {
        Optional<String> exampleComparative = listAdverbs.stream()
                .filter(adjective -> adjective.getAdjective().equalsIgnoreCase(letra))
                .map(Adjective::getExampleSuperlative)
                .findFirst();

        return exampleComparative.orElse(null);
    }

    public boolean adjectiveExists(String adjective) {
        return listAdverbs.stream().anyMatch(adj -> adj.getAdjective().equalsIgnoreCase(adjective));
    }
}
