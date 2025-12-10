package kr.java.thymeleaf.service;

import kr.java.thymeleaf.model.entity.Mentor;
import kr.java.thymeleaf.model.repository.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MentorService {
    private final MentorRepository mentorRepository;

    public List<Mentor> findAllWithMentees() {
        return mentorRepository.findAllWithMentees();
    }

    public Mentor findById(Long id) {
        return mentorRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("멘토를 찾을 수 없습니다: " + id)
        );
    }

    public Mentor findByIdWithMentees(Long id) {
        return mentorRepository.findByIdWithMentees(id).orElseThrow(
                () -> new IllegalArgumentException("멘토를 찾을 수 없습니다: " + id)
        );
    }

    @Transactional
    public Mentor save(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Transactional
    public void delete(Long id) {
        mentorRepository.deleteById(id);
    }
}
