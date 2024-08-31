package com.meubronze.app.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.meubronze.app.domain.Bronze;
import com.meubronze.app.exception.BadRequestException;
import com.meubronze.app.mapper.BronzeMapper;
import com.meubronze.app.repository.BronzeRepository;
import com.meubronze.app.request.bronze.BronzeDeleteRequestBody;
import com.meubronze.app.request.bronze.BronzePostRequestBody;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BronzeService {
    private BronzeRepository bronzeRepository;

    public Bronze findByIdOrThrowBadRequestException(Long id) {
        return this.bronzeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(String.format("Bronze %d not found", id)));
    }

    public List<Bronze> selectAllBronzes() {
        return this.bronzeRepository.findAll();
    }

    @Transactional(rollbackOn = Exception.class)
    public Long deleteBronzes(BronzeDeleteRequestBody bronzeDeleteRequestBody) throws BadRequestException {
        List<Long> bronzeIds = bronzeDeleteRequestBody.getBronzeIds();
        bronzeIds.forEach(id -> {
            this.findByIdOrThrowBadRequestException(id);
            this.bronzeRepository.deleteById(id);
        });
        return bronzeIds.get(bronzeIds.size() - 1);
    }

    @Transactional(rollbackOn = Exception.class)
    public Long insertBronze(BronzePostRequestBody bronzePostRequestBody) {
        Bronze bronze = this.bronzeRepository.save(BronzeMapper.INSTANCE.toBronze(bronzePostRequestBody));
        return bronze.getId();
    }
}
