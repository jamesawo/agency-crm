/*
 * @Author: james.aworo
 * @Date: 12/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.specification

import com.james.crm.api.core.common.DateRange
import com.james.crm.api.modules.pipeline.data.dto.PipelineSearchParams
import com.james.crm.api.modules.pipeline.domain.Pipeline
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component

@Component
class PipelineSpecification {

    companion object {

        fun criteria(request: PipelineSearchParams): Specification<Pipeline> {
            return Specification { root: Root<Pipeline>, _, criteriaBuilder: CriteriaBuilder ->
                val predicates: MutableList<Predicate> = ArrayList()
                if (!request.title.isNullOrBlank()) {
                    addTitlePredicate(predicates, request.title!!, criteriaBuilder, root)
                }

                if (request.dateRange != null) {
                    addDateRangePredicate(predicates, request.dateRange!!, criteriaBuilder, root)
                }

                if (!request.createdBy.isNullOrBlank()) {
                    addCreatedByPredicate(predicates, request.createdBy!!, criteriaBuilder, root)
                }

                if (request.isActive != null) {
                    addIsActivePredicate(predicates, request.isActive!!, criteriaBuilder, root)
                }

                if (request.numOfStages != null) {
                    addNumOfStagesPredicate(predicates, request.numOfStages!!, criteriaBuilder, root)
                }

                criteriaBuilder.and(*predicates.toTypedArray())
            }
        }

        private fun addTitlePredicate(
            predicates: MutableList<Predicate>,
            title: String,
            criteriaBuilder: CriteriaBuilder,
            root: Root<Pipeline>
        ) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%${title.lowercase()}%"))
        }

        private fun addDateRangePredicate(
            predicates: MutableList<Predicate>,
            dateRange: DateRange,
            criteriaBuilder: CriteriaBuilder,
            root: Root<Pipeline>
        ) {
            predicates.add(criteriaBuilder.between(root.get("createdAt"), dateRange.start, dateRange.end))
        }

        private fun addCreatedByPredicate(
            predicates: MutableList<Predicate>,
            createdBy: String,
            criteriaBuilder: CriteriaBuilder,
            root: Root<Pipeline>
        ) {
            // Todo: update this implementation
            // predicates.add(criteriaBuilder.equal(root.get("createdBy"), createdBy))
        }

        private fun addIsActivePredicate(
            predicates: MutableList<Predicate>,
            isActive: Boolean,
            criteriaBuilder: CriteriaBuilder,
            root: Root<Pipeline>
        ) {
            // predicates.add(criteriaBuilder.equal(root.get("isActive"), isActive))
        }

        private fun addNumOfStagesPredicate(
            predicates: MutableList<Predicate>,
            numOfStages: Int,
            criteriaBuilder: CriteriaBuilder,
            root: Root<Pipeline>
        ) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.size(root.get("stages")), numOfStages))
        }

    }
}

