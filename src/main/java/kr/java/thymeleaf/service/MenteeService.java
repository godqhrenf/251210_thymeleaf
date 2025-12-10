package kr.java.thymeleaf.service;

import kr.java.thymeleaf.model.entity.Mentee;
import kr.java.thymeleaf.model.entity.Mentor;
import kr.java.thymeleaf.model.repository.MenteeRepository;
import kr.java.thymeleaf.model.repository.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenteeService {
    private final MenteeRepository menteeRepository;
    private final MentorRepository mentorRepository;

    public List<Mentee> findAll() {
        return menteeRepository.findAll();
    }

    public Mentee findByIdWithMentor(Long id) {
        return menteeRepository.findByIdWithMentor(id).orElseThrow(
                () -> new IllegalArgumentException("멘티를 찾을 수 없습니다: " + id)
        );
    }

    @Transactional
    public Mentee save(Mentee mentee, Long mentorId) {
        if (mentorId != null) {
            Mentor mentor = mentorRepository.findById(mentorId).orElseThrow(
                    () -> new IllegalArgumentException("멘토를 찾을 수 없습니다: " + mentorId)
            );
            mentee.setMentor(mentor);
        }
        return menteeRepository.save(mentee);
    }

    @Transactional
    public void delete(Long id) {
        menteeRepository.deleteById(id);
    }
}
