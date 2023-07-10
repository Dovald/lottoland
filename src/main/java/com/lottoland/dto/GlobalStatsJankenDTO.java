package com.lottoland.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * GlobalStatsJankenDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-07-07T21:47:33.711908+02:00[Europe/Madrid]")


public class GlobalStatsJankenDTO   {
  @JsonProperty("TotalRounds")
  private Long totalRounds = null;

  @JsonProperty("TotalP1Wins")
  private Long totalP1Wins = null;

  @JsonProperty("TotalP2Wins")
  private Long totalP2Wins = null;

  @JsonProperty("TotalTies")
  private Long totalTies = null;

  public GlobalStatsJankenDTO totalRounds(Long totalRounds) {
    this.totalRounds = totalRounds;
    return this;
  }

  /**
   * Get totalRounds
   * @return totalRounds
   **/
  @Schema(example = "250", description = "")
  
    public Long getTotalRounds() {
    return totalRounds;
  }

  public void setTotalRounds(Long totalRounds) {
    this.totalRounds = totalRounds;
  }

  public GlobalStatsJankenDTO totalP1Wins(Long totalP1Wins) {
    this.totalP1Wins = totalP1Wins;
    return this;
  }

  /**
   * Get totalP1Wins
   * @return totalP1Wins
   **/
  @Schema(example = "100", description = "")
  
    public Long getTotalP1Wins() {
    return totalP1Wins;
  }

  public void setTotalP1Wins(Long totalP1Wins) {
    this.totalP1Wins = totalP1Wins;
  }

  public GlobalStatsJankenDTO totalP2Wins(Long totalP2Wins) {
    this.totalP2Wins = totalP2Wins;
    return this;
  }

  /**
   * Get totalP2Wins
   * @return totalP2Wins
   **/
  @Schema(example = "80", description = "")
  
    public Long getTotalP2Wins() {
    return totalP2Wins;
  }

  public void setTotalP2Wins(Long totalP2Wins) {
    this.totalP2Wins = totalP2Wins;
  }

  public GlobalStatsJankenDTO totalTies(Long totalTies) {
    this.totalTies = totalTies;
    return this;
  }

  /**
   * Get totalTies
   * @return totalTies
   **/
  @Schema(example = "70", description = "")
  
    public Long getTotalTies() {
    return totalTies;
  }

  public void setTotalTies(Long totalTies) {
    this.totalTies = totalTies;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GlobalStatsJankenDTO globalStatsJankenDTO = (GlobalStatsJankenDTO) o;
    return Objects.equals(this.totalRounds, globalStatsJankenDTO.totalRounds) &&
        Objects.equals(this.totalP1Wins, globalStatsJankenDTO.totalP1Wins) &&
        Objects.equals(this.totalP2Wins, globalStatsJankenDTO.totalP2Wins) &&
        Objects.equals(this.totalTies, globalStatsJankenDTO.totalTies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalRounds, totalP1Wins, totalP2Wins, totalTies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GlobalStatsJankenDTO {\n");
    
    sb.append("    totalRounds: ").append(toIndentedString(totalRounds)).append("\n");
    sb.append("    totalP1Wins: ").append(toIndentedString(totalP1Wins)).append("\n");
    sb.append("    totalP2Wins: ").append(toIndentedString(totalP2Wins)).append("\n");
    sb.append("    totalTies: ").append(toIndentedString(totalTies)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
