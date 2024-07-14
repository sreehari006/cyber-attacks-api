package com.poc.attacks_api.ransom;

import com.poc.attacks_api.ransom.entity.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RansomService {
    @Autowired
    private RansomRepository ransomRepository;

    @Transactional
    public Ransomware addRansomware(Ransomware ransomware) {
        return ransomRepository.save(ransomware);
    }

    @Transactional
    public void deleteRansomwareById(Long ransomwareId) {
        ransomRepository.deleteById(ransomwareId);
    }

    @Transactional
    public Ransomware patchRansomware(Long ransomwareId, Ransomware ransomwareUpdates) {
        Ransomware existing = ransomRepository.findById(ransomwareId)
                .orElseThrow(() -> new RuntimeException("Ransomware not found with id: " + ransomwareId));

        if (ransomwareUpdates.getDecryptor() != null) {
            existing.setDecryptor(ransomwareUpdates.getDecryptor());
        }

        if (ransomwareUpdates.getScreenshots() != null) {
            existing.setScreenshots(ransomwareUpdates.getScreenshots());
        }

        if (ransomwareUpdates.getMsDetection() != null) {
            existing.setMsDetection(ransomwareUpdates.getMsDetection());
        }

        if (ransomwareUpdates.getMsInfo() != null) {
            existing.setMsInfo(ransomwareUpdates.getMsInfo());
        }

        if (ransomwareUpdates.getSandbox() != null) {
            existing.setSandbox(ransomwareUpdates.getSandbox());
        }

        if (ransomwareUpdates.getIocs() != null) {
            existing.setIocs(ransomwareUpdates.getIocs());
        }

        if (ransomwareUpdates.getSnort() != null) {
            existing.setSnort(ransomwareUpdates.getSnort());
        }

        if (ransomwareUpdates.getRansomwareAlgo() != null) {
            for(RansomwareAlgo algo: ransomwareUpdates.getRansomwareAlgo()) {
                algo.setRansomware(existing);
                existing.getRansomwareAlgo().add(algo);
            }

        }

        if (ransomwareUpdates.getRansomwareAlias() != null) {
            for(RansomwareAlias alias: ransomwareUpdates.getRansomwareAlias()) {
                alias.setRansomware(existing);
                existing.getRansomwareAlias().add(alias);
            }
        }

        if (ransomwareUpdates.getRansomwareResources() != null) {
            for(RansomwareResources resources: ransomwareUpdates.getRansomwareResources()) {
                resources.setRansomware(existing);
                existing.getRansomwareResources().add(resources);
            }
        }

        if (ransomwareUpdates.getRansomwareExt() != null) {
            for(RansomwareExt ext: ransomwareUpdates.getRansomwareExt()) {
                ext.setRansomware(existing);
                existing.getRansomwareExt().add(ext);
            }
        }

        if (ransomwareUpdates.getRansomewareExtPattern() != null) {
            for(RansomewareExtPattern extPattern: ransomwareUpdates.getRansomewareExtPattern()) {
                extPattern.setRansomware(existing);
                existing.getRansomewareExtPattern().add(extPattern);
            }
        }

        if (ransomwareUpdates.getRansomwareNotes() != null) {
            for(RansomwareNotes notes: ransomwareUpdates.getRansomwareNotes()) {
                notes.setRansomware(existing);
                existing.getRansomwareNotes().add(notes);
            }
        }

        if (ransomwareUpdates.getRansomwareComments() != null) {
            for(RansomwareComments comments: ransomwareUpdates.getRansomwareComments()) {
                comments.setRansomware(existing);
                existing.getRansomwareComments().add(comments);
            }
        }

        return ransomRepository.save(existing);
    }

    @Transactional
    public Ransomware patchRansomware(Long ransomwareId, String propType, String value) {
        Ransomware existing = ransomRepository.findById(ransomwareId)
                .orElseThrow(() -> new RuntimeException("Ransomware not found with id: " + ransomwareId));

        switch (propType) {
            case "algo":
                existing.getRansomwareAlgo().removeIf(algo -> value.equalsIgnoreCase(algo.getAlgo()));
                break;
            case "alias":
                existing.getRansomwareAlias().removeIf(alias -> value.equalsIgnoreCase(alias.getAlias()));
                break;
            case "ext":
                existing.getRansomwareExt().removeIf(ext -> value.equalsIgnoreCase(ext.getExt()));
                break;
            case "ext-pattern":
                existing.getRansomewareExtPattern().removeIf(extPattern -> value.equalsIgnoreCase(extPattern.getExtPattern()));
                break;
            case "notes":
                existing.getRansomwareNotes().removeIf(notes -> value.equalsIgnoreCase(notes.getNotes()));
                break;
            case "comments":
                existing.getRansomwareComments().removeIf(comments -> value.equalsIgnoreCase(comments.getComments()));
                break;
            case "resources":
                existing.getRansomwareResources().removeIf(resources -> value.equalsIgnoreCase(resources.getResources()));
                break;
        }
        return ransomRepository.save(existing);
    }

    public Page<Ransomware> getRansomware(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ransomRepository.findAll(pageable);
    }

    public List<Ransomware> getRansomwareByName(String name) {
        return ransomRepository.getRansomwareByName(name);
    }
}
