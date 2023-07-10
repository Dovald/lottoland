package com.lottoland.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * JankenDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-07-07T21:32:37.917139+02:00[Europe/Madrid]")


public class JankenDTO   {
  @JsonProperty("player1")
  private String player1 = null;

  @JsonProperty("player2")
  private String player2 = null;

  @JsonProperty("result")
  private String result = null;

  @JsonProperty("playedAt")
  private String playedAt = null;

  public JankenDTO player1(String player1) {
    this.player1 = player1;
    return this;
  }

  /**
   * Get player1
   * @return player1
   **/
  @Schema(example = "Scissors", description = "")
  
    public String getPlayer1() {
    return player1;
  }

  public void setPlayer1(String player1) {
    this.player1 = player1;
  }

  public JankenDTO player2(String player2) {
    this.player2 = player2;
    return this;
  }

  /**
   * Get player2
   * @return player2
   **/
  @Schema(example = "Rock", description = "")
  
    public String getPlayer2() {
    return player2;
  }

  public void setPlayer2(String player2) {
    this.player2 = player2;
  }

  public JankenDTO result(String result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
   **/
  @Schema(example = "Player2 Wins", description = "")
  
    public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public JankenDTO playedAt(String playedAt) {
    this.playedAt = playedAt;
    return this;
  }

  /**
   * Get playedAt
   * @return playedAt
   **/
  @Schema(example = "dd-MM-yyyy HH:mm:ss.SSS", description = "")
  
    public String getPlayedAt() {
    return playedAt;
  }

  public void setPlayedAt(String playedAt) {
    this.playedAt = playedAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JankenDTO jankenDTO = (JankenDTO) o;
    return Objects.equals(this.player1, jankenDTO.player1) &&
        Objects.equals(this.player2, jankenDTO.player2) &&
        Objects.equals(this.result, jankenDTO.result) &&
        Objects.equals(this.playedAt, jankenDTO.playedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(player1, player2, result, playedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JankenDTO {\n");
    
    sb.append("    player1: ").append(toIndentedString(player1)).append("\n");
    sb.append("    player2: ").append(toIndentedString(player2)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    playedAt: ").append(toIndentedString(playedAt)).append("\n");
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
