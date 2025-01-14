package it.ntesConsulting.wearU.service.interfce.implmentation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import it.ntesConsulting.wearU.dto.CategoryDto;
import it.ntesConsulting.wearU.dto.Response;
import it.ntesConsulting.wearU.entity.Category;
import it.ntesConsulting.wearU.exception.NotFoundException;
import it.ntesConsulting.wearU.mapper.EntityDtoMapper;
import it.ntesConsulting.wearU.repository.CategoryRepository;
import it.ntesConsulting.wearU.service.interfce.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	
    private final CategoryRepository categoryRepository;
    private final EntityDtoMapper entityDtoMapper;
	
    @Override
    public Response createCategory(CategoryDto categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
        return Response.builder()
                .status(200)
                .message("Category created successfully")
                .build();
    }

    @Override
    public Response updateCategory(Long categoryId, CategoryDto categoryRequest) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new NotFoundException("Category Not Found"));
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
        return Response.builder()
                .status(200)
                .message("category updated successfully")
                .build();
    }
    
    /* 
    
*/

    @Override
    public Response getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = categories.stream()
                .map(entityDtoMapper::mapCategoryToDtoBasic)
                .collect(Collectors.toList());

        return  Response.builder()
                .status(200)
                .categoryList(categoryDtoList)
                .build();
    }

    @Override
    public Response getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new NotFoundException("Category Not Found"));
        CategoryDto categoryDto = entityDtoMapper.mapCategoryToDtoBasic(category);
        return Response.builder()
                .status(200)
                .category(categoryDto)
                .build();
    }

    @Override
    public Response deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new NotFoundException("Category Not Found"));
        categoryRepository.delete(category);
        return Response.builder()
                .status(200)
                .message("Category was deleted successfully")
                .build();
    }
	
	
	
	
	
}
