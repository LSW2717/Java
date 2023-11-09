package com.example.inhadb.controller;

import com.example.inhadb.entity.Lecture;
import com.example.inhadb.entity.Student;
import com.example.inhadb.entity.StudentStatus;
import com.example.inhadb.service.LectureService;
import com.example.inhadb.service.StudentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final StudentService studentService;
    private final LectureService lectureService;
    private final HttpSession session;

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html 템플릿을 반환
    }
    @PostMapping("/login")
    public String handleLogin(@RequestParam Long id, @RequestParam String phoneNumber, HttpSession session, RedirectAttributes redirectAttributes) {
        Optional<Student> studentOptional = studentService.findById(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            if (student.getPhoneNumber().equals(phoneNumber)) {
                session.setAttribute("loggedInStudent", student);
                if (student.getStatus() == StudentStatus.STUDENT) {
                    return "redirect:/delete"; // SUPER 사용자는 /delete 페이지로 리다이렉트
                } else {
                    return "redirect:/select"; // STUDENT 사용자는 /select 페이지로 리다이렉트
                }
            }
        }
        redirectAttributes.addFlashAttribute("loginError", "Invalid ID or phone number.");
        return "redirect:/login";
    }

    @GetMapping("/delete")
    public String showDeletePage(Model model, HttpSession session) {
        Student loggedInStudent = (Student) session.getAttribute("loggedInStudent");
        if (loggedInStudent != null && loggedInStudent.getStatus() == StudentStatus.STUDENT) { // SUPER 사용자만 접근 가능
            List<Lecture> lectures = lectureService.findAll();
            model.addAttribute("lectures", lectures);
            return "delete";
        } else {
            return "redirect:/login"; // 권한이 없으면 로그인 페이지로 리다이렉트
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteLecture(@PathVariable Long id, HttpSession session) {
        Student loggedInStudent = (Student) session.getAttribute("loggedInStudent");
        if (loggedInStudent != null && loggedInStudent.getStatus() == StudentStatus.STUDENT) { // SUPER 사용자만 삭제 가능
            lectureService.delete(id);
            return "redirect:/delete";
        } else {
            return "redirect:/login"; // 권한이 없으면 로그인 페이지로 리다이렉트
        }
    }


}
