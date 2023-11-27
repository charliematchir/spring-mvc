package com.mvc.mvccrud.controller;

import com.mvc.mvccrud.domain.dto.ItemParamDto;
import com.mvc.mvccrud.domain.item.Item;
import com.mvc.mvccrud.domain.item.ItemRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor // 초기화 안된 final 이나 Not null 생성자 생성
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping("/items")
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "/items";
    }

    @GetMapping("/items/{itemid}")
    public String item(Model model, @PathVariable long itemid) {
        Item item = itemRepository.findById(itemid);
        model.addAttribute("item", item);
        return "/item";
    }

    @GetMapping("/items/{itemid}/edit")
    public String editForm(Model model, @PathVariable long itemid) {
        Item item = itemRepository.findById(itemid);
        // Object value 추가하는것
        model.addAttribute(item);
        return "/editForm";
    }

    // ModelAttribute는 전달하는 파라미터 오브젝트에 맵핑
    @PostMapping("/items/{itemid}/edit")
    public String edit(@PathVariable long itemid, @ModelAttribute ItemParamDto paramDto) {
        itemRepository.update(itemid, paramDto);
        return "redirect:/items/{itemid}";
    }


    @GetMapping("/items/add")
    public String addForm() {
        return "/addForm";
    }

    @PostMapping("/items/add")
    public String save(@ModelAttribute ItemParamDto paramDto, RedirectAttributes redirectAttributes) {
        Item item = itemRepository.save(paramDto);
        redirectAttributes.addAttribute("itemid", item.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/items/{itemid}";
    }

//    @PostMapping("/add")
//    public Long save(@RequestBody ItemParamDto paramDto) {
//        return itemRepository.save(paramDto).getId();
//    }

}
